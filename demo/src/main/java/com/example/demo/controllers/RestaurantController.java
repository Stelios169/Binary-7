package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    /*private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // Endpoint για να πάρουμε το email ενός εστιατορίου με βάση το ingredient ID
    @GetMapping("/email/{ingredientId}")
    public ResponseEntity<List<Restaurant>> getRestaurantEmailByIngredientId(@PathVariable int ingredientId) {
        List<Restaurant> email = restaurantService.getRestaurantEmailByIngredientId(ingredientId);
        if (restaurants.isEmpty()) {
            return ResponseEntity.notFound().build(); // Επιστρέφει 404 αν δεν βρεθούν εστιατόρια
        }
        return ResponseEntity.ok(restaurants); // Επιστρέφει τα εστιατόρια αν βρεθούν
    }
        //return email.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint για να πάρουμε τα εστιατόρια με συστατικά που λήγουν
    @GetMapping("/expiring-ingredients")
    public ResponseEntity<Optional<Restaurant>> getRestaurantsWithExpiringIngredients(
            @RequestParam("expiryThreshold") LocalDate expiryThreshold) {
        List<Restaurant> restaurants = restaurantService.getRestaurantsWithExpiringIngredients(expiryThreshold);
        if (restaurants.isEmpty()) {
            return ResponseEntity.notFound().build(); // Επιστρέφει 404 αν δεν βρεθούν εστιατόρια
        }
        return ResponseEntity.ok(restaurants); // Επιστρέφει τα εστιατόρια αν βρεθούν
    }
        //return ResponseEntity.ok(restaurants);
    

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
        return ResponseEntity.ok(savedRestaurant); */
    }

