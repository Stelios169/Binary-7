package com.example.demo.services;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import com.example.demo.models.Ingredient;
import com.example.demo.models.Recipe;
import com.example.demo.models.RecipeIngredient;
import com.example.demo.repositories.IngredientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Map;
 
@Service
public class RecipeOptimizerService {
    private final IngredientRepository ingredientRepository;
    private final SpoonacularClient spoonacularClient;
 
    public RecipeOptimizerService(IngredientRepository ingredientRepository, SpoonacularClient spoonacularClient) {
        this.ingredientRepository = ingredientRepository;
        this.spoonacularClient = spoonacularClient;
    }
 
    public List<Recipe> findOptimizedRecipes(LocalDate thresholdDate, int budget) {
        // Step 1: Retrieve ingredients that are expiring soon
        List<Ingredient> expiringIngredients = ingredientRepository.findByIngredientExpDateBefore(thresholdDate);
        System.out.println("Expiring Ingredients" + expiringIngredients);
 
        // Step 2: Fetch recipes based on the expiring ingredients
        List<Recipe> recipes = spoonacularClient.fetchRecipes(expiringIngredients);
 
        // Step 3: Apply Greedy for initial sorting
        recipes.sort((r1, r2) -> Double.compare(
                calculateRecipeScore(r2) / r2.getPricePerServing(),
                calculateRecipeScore(r1) / r1.getPricePerServing()));
 
        // Step 4: Apply Knapsack optimization
        return knapsackOptimization(recipes, expiringIngredients, budget);
    }
 
    private List<Recipe> knapsackOptimization(List<Recipe> recipes, List<Ingredient> expiringIngredients, int budget) {
        int n = recipes.size();
        int[][] dp = new int[n + 1][budget + 1];
        Map<Integer, Recipe> recipeIndexMap = new HashMap<>();
 
        for (int i = 1; i <= n; i++) {
            Recipe recipe = recipes.get(i - 1);
            int servings = calculateServings(recipe, expiringIngredients); // Κλήση της μεθόδου
            if (servings == 0) continue; // Αν δεν υπάρχουν δυνατότητες, παρακάμπτουμε τη συνταγή
            int cost = (int) recipe.getPricePerServing();
            int score = (int) calculateRecipeScore(recipe);
 
            for (int b = 1; b <= budget; b++) {
                if (cost <= b) {
                    dp[i][b] = Math.max(dp[i - 1][b], dp[i - 1][b - cost] + score);
                } else {
                    dp[i][b] = dp[i - 1][b];
                }
            }
            recipeIndexMap.put(i, recipe);
        }
       
        // Reconstruct the solution
        List<Recipe> selectedRecipes = new ArrayList<>();
        int b = budget;
        for (int i = n; i > 0 && b > 0; i--) {
            if (dp[i][b] != dp[i - 1][b]) {
                Recipe recipe = recipeIndexMap.get(i);
                selectedRecipes.add(recipe);
                b -= (int) recipe.getPricePerServing();
            }
        }
 
        return selectedRecipes;
    }
    private int calculateServings(Recipe recipe, List<Ingredient> expiringIngredients) {
        int maxServings = Integer.MAX_VALUE;
        for (RecipeIngredient ri : recipe.getUsedIngredients()) {
            Optional<Integer> possibleServings = expiringIngredients.stream()
                    .filter(i -> i.getIngredient_name().equals(ri.getName()))
                    .map(i -> (int) (i.getIngredient_stock() / ri.getAmount()))
                    .findFirst();
   
            if (possibleServings.isPresent()) {
                maxServings = Math.min(maxServings, possibleServings.get());
            } else {
                return 0; // If any required ingredient is missing, servings are 0
            }
        }
        return maxServings;
    }
    private double calculateRecipeScore(Recipe recipe) {
        int sum = recipe.getUsedIngredients().size() + recipe.getMissedIngredients().size();
        double usageScore = (double) recipe.getUsedIngredients().size() / sum;
        double costScore = 1.0 / recipe.getPricePerServing();
        return usageScore * 0.5 + costScore * 0.2;
    }  
}
 
 