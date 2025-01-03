package com.example.demo.repositories;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.example.demo.models.Ingredient;
 
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    @Query("SELECT i FROM Ingredient i " +
       "JOIN DishIngredients di ON i.ingredient_id = di.id.ingredient_id " +
       "JOIN Dish d ON di.id.dish_id = d.dish_id " +
       "WHERE i.ingredient_exp_date <= :expiryThreshold")
    List<Ingredient> findExpiringIngredientsForRestaurant(int restaurant_id, LocalDate expiryThreshold);   
}
