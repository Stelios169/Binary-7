package com.example.demo.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.example.demo.models.Restaurant;
 
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
   @Query("SELECT DISTINCT r FROM Restaurant r " +
       "JOIN r.dishes d " + // Χρησιμοποιούμε τη σχέση για τα dishes
       "JOIN DishIngredients di ON d.dish_id = di.id.dish_id " +
       "JOIN Ingredient i ON di.id.ingredient_id = i.ingredient_id " +
       "WHERE i.ingredient_exp_date <= :expiryThreshold")
    List<Restaurant> findRestaurantsWithExpiringIngredients(LocalDate expiryThreshold);
}
