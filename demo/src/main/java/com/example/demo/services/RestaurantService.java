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

package com.example.demo.services;

import com.example.demo.models.Restaurant;
import com.example.demo.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private static final Logger logger = LoggerFactory.getLogger(RestaurantService.class);
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // Μέθοδος για την ανάκτηση email ενός εστιατορίου από ένα ingredient ID
    public Optional<String> getRestaurantEmailByIngredientId(int ingredientId) {
        logger.info("Fetching email for ingredient ID: {}", ingredientId);
        return restaurantRepository.findRestaurantEmailByIngredientId(ingredientId);
    }

    // Μέθοδος για την ανάκτηση εστιατορίων με συστατικά που λήγουν
    public List<Restaurant> getRestaurantsWithExpiringIngredients(LocalDate expiryThreshold) {
        logger.info("Fetching restaurants with ingredients expiring before: {}", expiryThreshold);
        return restaurantRepository.findRestaurantsWithExpiringIngredients(expiryThreshold);
    }

    // Μέθοδος για την ανάκτηση όλων των εστιατορίων
    public List<Restaurant> getAllRestaurants() {
        logger.info("Fetching all restaurants");
        return restaurantRepository.findAll();
    }

    // Μέθοδος για την αποθήκευση ενός νέου εστιατορίου
    public Restaurant saveRestaurant(Restaurant restaurant) {
        logger.info("Saving restaurant: {}", restaurant.getRestaurant_name());
        return restaurantRepository.save(restaurant);
    }
}

