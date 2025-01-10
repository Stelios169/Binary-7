package com.example.demo.controllers;

import com.example.demo.models.Restaurant;
import com.example.demo.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
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
