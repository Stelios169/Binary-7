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

import com.example.demo.services.RestaurantService;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Restaurant;
import java.util.List;
import java.time.LocalDate;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // Endpoint για να πάρουμε το email ενός εστιατορίου με βάση το ingredient ID
    @GetMapping("/email/{ingredientId}")
    public ResponseEntity<String> getRestaurantEmailByIngredientId(@PathVariable int ingredientId) {
        Optional<String> email = restaurantService.getRestaurantEmailByIngredientId(ingredientId);
        return email.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint για να πάρουμε τα εστιατόρια με συστατικά που λήγουν
    @GetMapping("/expiring-ingredients")
    public ResponseEntity<List<Restaurant>> getRestaurantsWithExpiringIngredients(
            @RequestParam("expiryThreshold") LocalDate expiryThreshold) {
        List<Restaurant> restaurants = restaurantService.getRestaurantsWithExpiringIngredients(expiryThreshold);
        return ResponseEntity.ok(restaurants);
    }
    

    // Endpoint για να πάρουμε όλα τα εστιατόρια
    @GetMapping("/")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    // Endpoint για να προσθέσουμε ένα νέο εστιατόριο
    @PostMapping("/")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.ok(savedRestaurant); 
    }
}

