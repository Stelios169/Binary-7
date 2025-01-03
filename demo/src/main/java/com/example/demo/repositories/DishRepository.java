package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.models.Dish;

import java.util.Optional;
 
public interface DishRepository extends JpaRepository<Dish, Integer> {
    
        @Query("SELECT r.restaurant_email FROM Restaurant r " +
       "JOIN r.dishes d " +
       "JOIN d.ingredients di " +
       "WHERE di.ingredient.ingredient_id = :ingredient_id")
    Optional<String> findRestaurantEmailByIngredientId(@Param("ingredient_id") int ingredientId);
}
