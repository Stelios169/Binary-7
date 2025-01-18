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
