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
import java.util.Optional;

import com.example.demo.models.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
        
        @Query("SELECT r FROM Restaurant r WHERE r.restaurant_email = :restaurant_email")
        Optional<Restaurant> findByEmail(@Param("restaurant_email") String restaurant_email);

        @Query("SELECT DISTINCT r.restaurant_email FROM Restaurant r " +
                        "JOIN r.restaurantDishes rd " +
                        "JOIN rd.dish d " +
                        "JOIN d.ingredients di " +
                        "WHERE di.id.ingredient_id = :ingredient_id")
        Optional<String> findRestaurantEmailByIngredientId(@Param("ingredient_id") int ingredientId); 

        /*@Query("SELECT DISTINCT r FROM Restaurant r " +
       "JOIN r.restaurantDishes rd " +
       "JOIN rd.dish d " +
       "JOIN d.ingredients di " +
       "WHERE di.id.ingredient_id = :ingredient_id " +
       "AND di.ingredient.ingredient_exp_date <= :expiryThreshold")
        List<Restaurant> findRestaurantEmailByIngredientId(@Param("ingredient_id") int ingredient_id, 
                                                   @Param("expiryThreshold") LocalDate expiryThreshold);*/





         @Query("SELECT DISTINCT r FROM Restaurant r " +
                        "JOIN r.restaurantDishes rd " +
                        "JOIN rd.dish d " +
                        "JOIN d.ingredients di " +
                        "JOIN di.ingredient i " +
                        "WHERE i.ingredient_exp_date <= :expiryThreshold")
        List<Restaurant> findRestaurantsWithExpiringIngredients(@Param("expiryThreshold") LocalDate expiryThreshold); 




        /*@Query("SELECT r FROM Restaurant r " +
                "JOIN r.restaurantDishes rd " +
                "JOIN rd.dish d " +
                "JOIN d.ingredients di " +
                "JOIN di.ingredient i " +
                "WHERE i.ingredient_exp_date <= :expiryThreshold")
        List<Restaurant> findRestaurantsWithExpiringIngredients(@Param("expiryThreshold") LocalDate expiryThreshold);*/

}
