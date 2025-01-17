 package com.example.demo.controllers;

import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeOptimizerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
 import org.springframework.ui.Model;
import java.time.LocalDate;
import java.util.List;
 import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeController {
 @Test
 void testGetIngredientsPage() {
 Mock the RecipeOptimizerService
 RecipeOptimizerService mockService = mock(RecipeOptimizerService.class);
 RecipeController controller = new RecipeController(mockService);
 Model mockModel = mock(Model.class);

 // Call the method
 String viewName = controller.getIngredientsPage(mockModel);

 // Verify interactions
 verify(mockModel).addAttribute("budget", 0);

 // Assert the returned view name
 assertEquals("ingredients", viewName);
 }

 @Test
 void testGetOptimizedRecipes() {
 // Mock the RecipeOptimizerService
 RecipeOptimizerService mockService = mock(RecipeOptimizerService.class);
 RecipeController controller = new RecipeController(mockService);
 Model mockModel = mock(Model.class);

 // Set up test data
 int budget = 50;
 List<Recipe> mockRecipes = new ArrayList<>();
 Recipe mockRecipe = mock(Recipe.class);
 mockRecipes.add(mockRecipe);

 when(mockService.findOptimizedRecipes(LocalDate.now().plusDays(7),
 budget)).thenReturn(mockRecipes);

 // Call the method
 String viewName = controller.getOptimizedRecipes(budget, mockModel);

 // Verify interactions
 verify(mockService).findOptimizedRecipes(LocalDate.now().plusDays(7),
 budget);
 verify(mockModel).addAttribute("recipes", mockRecipes);
 verify(mockModel).addAttribute("budget", budget);

 // Assert the returned view name
 assertEquals("ingredients", viewName);
 }
 }
