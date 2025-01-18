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
 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.Test;
 import java.util.List;
 import java.util.ArrayList;

 public class RecipeTest {
 @Test
 void testRecipeConstructorAndGetters() {
 List<RecipeIngredient> usedIngredients = new ArrayList<>();
 List<RecipeIngredient> missedIngredients = new ArrayList<>();
 Recipe recipe = new Recipe(1, "Test Recipe", "test_image.jpg", 2, 3,
 usedIngredients, missedIngredients, 100);

 assertEquals(1, recipe.getId());
 assertEquals("Test Recipe", recipe.getTitle());
 assertEquals("test_image.jpg", recipe.getImage());
 assertEquals(2, recipe.getUsedIngredientCount());
 assertEquals(3, recipe.getMissedIngredientCount());
 assertEquals(usedIngredients, recipe.getUsedIngredients());
 assertEquals(missedIngredients, recipe.getMissedIngredients());
 assertEquals(100, recipe.getLikes());
 }

 @Test
 void testPricePerServing() {
 Recipe recipe = new Recipe(1, "Test Recipe", "test_image.jpg", 2, 3, new
 ArrayList<>(), new ArrayList<>(), 100);
 recipe.setPricePerServing(15.5); // Use the setter method
 //recipe.pricePerServing = 15.5;


 assertEquals(15.5, recipe.getPricePerServing());
 }
 }
