package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.example.demo.models.Ingredient;
import com.example.demo.models.Restaurant;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class EmailController {
    private final EmailService emailService;
    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/sendExpiringIngredientsEmail")
    public ResponseEntity<String> sendExpiringIngredientsEmail() {
        try{
            // Ορισμός του χρονικού ορίου (7 ημέρες από σήμερα)
            LocalDate expiryThreshold = LocalDate.now().plusDays(7);
            
            // Εύρεση εστιατορίων με υλικά που λήγουν σύντομα        
            List<Restaurant> restaurants = emailService.findRestaurantsWithExpiringIngredients(expiryThreshold);
            System.out.println("Found Restaurants: " + restaurants);
            if (restaurants.isEmpty()) {
                return ResponseEntity.ok("No restaurants with expiring ingredients.");             
            }
            for (Restaurant restaurant : restaurants) {
                List<Ingredient> expiringIngredients = emailService.findExpiringIngredientsForRestaurant(restaurant.getRestaurant_id(), expiryThreshold);
                System.out.println("found ingredients" + expiringIngredients);
                if (!expiringIngredients.isEmpty()) {
                    emailService.sendExpiringIngredientsNotification(restaurant.getRestaurant_email(), "Expiring Ingredients: ", expiringIngredients);
                }
            }
            return ResponseEntity.ok("Emails sent successfully.");    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send emails: " + e.getMessage());
        }
    }  
}

   