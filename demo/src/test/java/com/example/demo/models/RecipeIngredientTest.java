package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RecipeIngredientTest {
   @Test
        void testRecipeIngredientConstructorAndGetters() {
            RecipeIngredient ingredient = new RecipeIngredient(1, 2.5, "kg", "Tomato", "2.5 kg Tomato", "tomato.jpg");

            assertEquals(1, ingredient.getId());
            assertEquals(2.5, ingredient.getAmount());
            assertEquals("kg", ingredient.getUnit());
            assertEquals("Tomato", ingredient.getName());
            assertEquals("2.5 kg Tomato", ingredient.getOriginal());
            assertEquals("tomato.jpg", ingredient.getImage());
    }
}

