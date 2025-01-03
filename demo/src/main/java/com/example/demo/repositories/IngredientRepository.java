package com.example.demo.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Ingredient;
 
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    
    
}
