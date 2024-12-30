package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Ingredient;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

 
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    @Query("SELECT r.email FROM Restaurant r " +
       "JOIN r.dish d " +
       "JOIN d.dishIngredients di " +
       "WHERE di.ingredient.id = :ingredient_id")
    String findRestaurantEmailByIngredientId(@Param("ingrId") int ingredient_id);
 
}
