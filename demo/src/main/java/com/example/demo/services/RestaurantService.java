package com.example.demo.services;

import com.example.demo.models.Restaurant;
import com.example.demo.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

