/*
 * Copyright 2024-2025 Binary 7
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo.controllers;

import com.example.demo.models.Recipe;
import com.example.demo.models.RecipeIngredient;
import com.example.demo.services.RecipeOptimizerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTest {

    @Mock
    private RecipeOptimizerService recipeOptimizerService;

    @InjectMocks
    private RecipeController recipeController;

    @Mock
    private Model model;

    @Test
    void testGetIngredientsPage() {
        // Call the method
        String viewName = recipeController.getIngredientsPage(model);

        // Verify interactions
        verify(model).addAttribute("budget", 0);

        // Assert the returned view name
        assertEquals("daily-dish", viewName);
    }

    @Test
    void testGetOptimizedRecipes() {
        // Set up test data
        int budget = 50;
         List<RecipeIngredient> usedIngredients = new ArrayList<>();
        List<RecipeIngredient> missedIngredients = new ArrayList<>();
        
        List<Recipe> mockRecipes = new ArrayList<>();
        mockRecipes.add(new Recipe(
            1,                     
            "Mock Recipe",         
            "Mock Image URL",      
            3,                     
            2,                     
            usedIngredients,       
            missedIngredients,     
            100                   
        ));

        when(recipeOptimizerService.findOptimizedRecipes(any(LocalDate.class), eq(budget))).thenReturn(mockRecipes);

        // Call the method
        String viewName = recipeController.getOptimizedRecipes(budget, model);

        // Verify interactions
        verify(recipeOptimizerService).findOptimizedRecipes(any(LocalDate.class), eq(budget));
        verify(model).addAttribute("recipes", mockRecipes);
        verify(model).addAttribute("budget", budget);

        // Assert the returned view name
        assertEquals("daily-dish", viewName);
    }
}
    