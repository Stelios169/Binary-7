package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.demo.models.Ingredient;
import com.example.demo.models.Recipe;
import com.example.demo.models.RecipeIngredient;
import com.example.demo.repositories.IngredientRepository;
import java.util.List;
import java.util.Collections;

public class RecipeOptimizerTest {

    @Mock
    private IngredientRepository ingredientRepository;
    
    @Mock
    private SpoonacularClient spoonacularClient;
    
    @InjectMocks
    private RecipeOptimizerService recipeOptimizerService;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeOptimizerService = new RecipeOptimizerService(ingredientRepository, spoonacularClient);
    }
    
    @Test
    void testFindOptimizedRecipes() {
    // Mock δεδομένα
    LocalDate thresholdDate = LocalDate.now();

    // Δημιουργία του αντικειμένου Ingredient με τον σωστό constructor
    Ingredient ingredient = new Ingredient("Tomato", 10.0, 1, 2.5, "kg", thresholdDate);  // Σωστά ορίσματα

    // Δημιουργία των αντικειμένων RecipeIngredient με τον σωστό constructor
    RecipeIngredient usedIngredient = new RecipeIngredient(1, 5.0, "kg", "Tomato", "Fresh tomato", "image_url");
    RecipeIngredient missedIngredient = new RecipeIngredient(2, 3.0, "kg", "Tomato", "Fresh tomato", "image_url");

    // Δημιουργία της μεταβλητής λίστας
    List<RecipeIngredient> usedIngredients = new ArrayList<>();
    usedIngredients.add(usedIngredient);  // Προσθήκη του used ingredient στη λίστα

    List<RecipeIngredient> missedIngredients = new ArrayList<>();
    missedIngredients.add(missedIngredient);  // Προσθήκη του missed ingredient στη λίστα

    // Δημιουργία του Recipe αντικειμένου με τον σωστό constructor
    Recipe recipe = new Recipe(
        1,                          // id
        "Recipe 1",                 // τίτλος
        "image_url",                // εικόνα
        usedIngredients.size(),     // usedIngredientCount
        missedIngredients.size(),   // missedIngredientCount
        usedIngredients,            // usedIngredients
        missedIngredients,          // missedIngredients
        100                         // likes
    );

    // Mocking της συμπεριφοράς του repository και του client
    when(ingredientRepository.findByIngredientExpDateBefore(thresholdDate))
        .thenReturn(new ArrayList<>(List.of(ingredient))); // Χρησιμοποίησε μια mutable λίστα εδώ
    when(spoonacularClient.fetchRecipes(anyList()))
        .thenReturn(new ArrayList<>(List.of(recipe))); // Και εδώ δημιουργούμε mutable λίστα

    // Κλήση της μεθόδου
    List<Recipe> optimizedRecipes = recipeOptimizerService.findOptimizedRecipes(thresholdDate, 50);

    // Assertions
    assertNotNull(optimizedRecipes);
    assertEquals(1, optimizedRecipes.size());
    assertEquals("Recipe 1", optimizedRecipes.get(0).getTitle());

    }
    
    @Test
    void testFindOptimizedRecipes_noIngredients() {
    // Mock data
    LocalDate thresholdDate = LocalDate.now();
    when(ingredientRepository.findByIngredientExpDateBefore(thresholdDate))
    .thenReturn(Collections.emptyList());
    
    // Call the method
    List<Recipe> optimizedRecipes = recipeOptimizerService.findOptimizedRecipes(thresholdDate, 50);
    
    // Assertions
    assertNotNull(optimizedRecipes);
    assertTrue(optimizedRecipes.isEmpty());
    }
}
       

    
 