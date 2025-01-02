package com.example.demo.services;
 
import com.example.demo.models.DishProfit;
import com.example.demo.models.Ingredient;
import com.example.demo.repositories.DishRepository;
import com.example.demo.repositories.IngredientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
 
@Service

public class MenuService {
 
    private final DishRepository dishRepository;
    private final IngredientRepository ingredientRepository;
      
    public MenuService(DishRepository dishRepository, IngredientRepository ingredientRepository) {
        
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;

    }
 
    public List<DishProfit> calculateAndSortDishProfit() {

        return dishRepository.calculateAndSortDishProfit();

    }
 
    public Map<String, List<DishProfit>> groupMenuByCategory(List<DishProfit> dishProfits) {

        return dishProfits.stream()
                .collect(Collectors.groupingBy(DishProfit::getCategoryName));

    }
     
    public List<DishProfit> filterMenuByUserInput(

            List<DishProfit> dishProfits, String category, float maxPrice,

            List<String> allergens) {
 
        return dishProfits.stream()

                .filter(dish -> dish.getCategoryName().equalsIgnoreCase(category))
                .filter(dish -> dish.getPrice() <= maxPrice)
                .filter(dish -> !containsAllergen(dish.getDishId(), allergens))
                .collect(Collectors.toList());

    }
 
    private boolean containsAllergen(int dishId, List<String> allergens) {

        List<Ingredient> ingredients = getIngredientsForDish(dishId);

        for (Ingredient ingredient : ingredients) {

            if (allergens.contains(ingredient.getIngredient_name())) {

                return true;

            }

        }
        return false;

    }
    private List<Ingredient> getIngredientsForDish(int dishId) {

        return ingredientRepository.findByDishId(dishId);

    } 

}

 
