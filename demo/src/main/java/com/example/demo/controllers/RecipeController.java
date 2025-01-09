package com.example.demo.controllers;

import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeOptimizerService;
import java.util.List;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
 @RestController
@RequestMapping("/api/recipes")
public class RecipeController {
 
    private final RecipeOptimizerService recipeOptimizerService;
    public RecipeController(RecipeOptimizerService recipeOptimizerService) {
        this.recipeOptimizerService = recipeOptimizerService;
    }
    @GetMapping("/optimize")
    public List<Recipe> getOptimizedRecipes(@RequestParam int budget) {
        return recipeOptimizerService.findOptimizedRecipes(LocalDate.now().plusDays(7), budget);
    }  
}