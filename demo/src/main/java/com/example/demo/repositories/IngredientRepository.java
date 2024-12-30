package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Ingredient;
 
public interface IngredientRepository extends JpaRepository<Ingredient, int> {
    @Query("SELECT r.email FROM Restaurant r " +
       "JOIN r.dish d " +
       "JOIN d.dishIngredients di " +
       "WHERE di.ingredient.id = :ingredient_id")
    String findRestaurantEmailByIngredientId(@Param("ingrId") int ingredient_id);
 
}
