package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.repositories.IngredientRepository;
import com.example.demo.repositories.RestaurantRepository;
import com.example.demo.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.example.demo.models.Ingredient;
import com.example.demo.models.Restaurant;
import java.time.LocalDate;

@Controller
@RestController
@RequestMapping("/api")
public class EmailController {
    private final EmailService emailService;
    private final IngredientRepository ingredientRepository;
    private final RestaurantRepository restaurantRepository;
    public EmailController(EmailService emailService, IngredientRepository ingredientRepository, RestaurantRepository restaurantRepository) {
        this.emailService = emailService;
        this.ingredientRepository = ingredientRepository;
        this.restaurantRepository = restaurantRepository;
    }
    @PostMapping("/sendExpiringIngredientsEmail")
    public String sendExpiringIngredientsEmail(@RequestParam String to,
                                               @RequestParam String subject,
                                               @RequestParam String text) {
        try{
            // Ορισμός του χρονικού ορίου (7 ημέρες από σήμερα)
            LocalDate expiryThreshold = LocalDate.now().plusDays(7);
            // Εύρεση εστιατορίων με υλικά που λήγουν σύντομα        
            List<Restaurant> restaurants = restaurantRepository.findRestaurantsWithExpiringIngredients(expiryThreshold);
            System.out.println("Found Restaurants: " + restaurants);
            if (restaurants == null || restaurants.isEmpty()) {            
                 return "Δεν υπάρχουν εστιατόρια με υλικά που λήγουν σύντομα."; 
            }
            for (Restaurant restaurant : restaurants) {
                List<Ingredient> expiringIngredients = ingredientRepository.findExpiringIngredientsForRestaurant(restaurant.getRestaurant_id(), expiryThreshold);
                System.out.println("found ingredients" + expiringIngredients);
                if (expiringIngredients.isEmpty()) {
                    return "No expiring ingredients";
                }
                if (!expiringIngredients.isEmpty()) {
                    emailService.sendExpiringIngredientsNotification(restaurant.getRestaurant_email(), subject, expiringIngredients, text);
                }
            }
            return "Emails sent succesfully.";    
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send emails";
        }
    }  
}
