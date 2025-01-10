package com.example.demo.services;

import com.example.demo.models.Restaurant;
import com.example.demo.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // Μέθοδος για την ανάκτηση email ενός εστιατορίου από ένα ingredient ID
    public Optional<String> getRestaurantEmailByIngredientId(int ingredientId) {
        return restaurantRepository.findRestaurantEmailByIngredientId(ingredientId);
    }

    // Μέθοδος για την ανάκτηση εστιατορίων με συστατικά που λήγουν
    public List<Restaurant> getRestaurantsWithExpiringIngredients(LocalDate expiryThreshold) {
        return restaurantRepository.findRestaurantsWithExpiringIngredients(expiryThreshold);
    }

    // Μέθοδος για την ανάκτηση όλων των εστιατορίων
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    // Μέθοδος για την αποθήκευση ενός νέου εστιατορίου
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
