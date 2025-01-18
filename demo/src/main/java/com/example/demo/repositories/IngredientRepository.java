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

package com.example.demo.repositories;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.example.demo.models.Ingredient;
 
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    @Query("SELECT i FROM Ingredient i WHERE i.ingredient_exp_date <= :expiryThreshold")
    List<Ingredient> findByIngredientExpDateBefore(@Param("expiryThreshold") LocalDate expiryThreshold);

    @Query("SELECT i FROM Ingredient i " +
       "JOIN i.dishIngredients di " + // Χρησιμοποιούμε τη σχέση DishIngredients
       "JOIN di.dish d " +            // Χρησιμοποιούμε τη σχέση Dish
       "JOIN d.restaurantDishes rd " + // Σύνδεση με RestaurantDishes
       "JOIN rd.restaurant r " +       // Σύνδεση με Restaurant
       "WHERE r.restaurant_id = :restaurant_id " +
       "AND i.ingredient_exp_date >= CURRENT_DATE " +  
       "AND i.ingredient_exp_date <= :expiryThreshold")
    List<Ingredient> findExpiringIngredientsForRestaurant(@Param("restaurant_id") int restaurantId, 
                                                      @Param("expiryThreshold") LocalDate expiryThreshold);
}
