package com.example.demo.repositories;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.example.demo.models.Ingredient;
 
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    @Query("SELECT i FROM Ingredient i WHERE i.ingredient_exp_date <= :expiryThreshold")
    List<Ingredient> findByIngredientExpDateBefore(@Param("expiryThreshold") LocalDate expiryThreshold);

    @Query("SELECT i FROM Ingredient i " +
       "JOIN i.dishIngredients di " + // Χρησιμοποιούμε τη σχέση DishIngredients
       "JOIN di.dish d " +            // Χρησιμοποιούμε τη σχέση Dish
       "JOIN d.restaurantDishes rd " + // Σύνδεση με RestaurantDishes
       "JOIN rd.restaurant r " +       // Σύνδεση με Restaurant
       "WHERE r.restaurant_id = :restaurant_id " +
       "AND i.ingredient_exp_date >= CURRENT_DATE " +  
       "AND i.ingredient_exp_date <= :expiryThreshold")
    List<Ingredient> findExpiringIngredientsForRestaurant(@Param("restaurant_id") int restaurantId, 
                                                      @Param("expiryThreshold") LocalDate expiryThreshold);
}
