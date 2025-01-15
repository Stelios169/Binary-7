package com.example.demo.controllers;

import com.example.demo.services.EmailService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collections;  
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import com.example.demo.models.Restaurant;
import com.example.demo.models.Ingredient;
import java.time.LocalDate;
import java.util.Arrays;
    
public class EmailControllerTest {
    
        private final EmailService emailService = Mockito.mock(EmailService.class);
        private final EmailController emailController = new EmailController(emailService);
    
        @Test
        void testSendExpiringIngredientsEmail_NoRestaurants() {
            // Mock συμπεριφορά
            when(emailService.findRestaurantsWithExpiringIngredients(any())).thenReturn(Collections.emptyList());
    
            // Εκτέλεση
            ResponseEntity<String> response = emailController.sendExpiringIngredientsEmail();
    
            // Έλεγχος
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals("No restaurants with expiring ingredients.", response.getBody());
            verify(emailService, times(1)).findRestaurantsWithExpiringIngredients(any());
        }
    
        @Test
        void testSendExpiringIngredientsEmail_Success() {
            // Mock δεδομένα
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurant_id(2);
            restaurant.setRestaurant_email("stella.panopoulou678@gmail.com");
            Ingredient ingredient = new Ingredient();
            ingredient.setIngredient_name("Salmon");
            ingredient.setIngredient_exp_date(LocalDate.now().plusDays(3));
    
            // Mock συμπεριφορά
            when(emailService.findRestaurantsWithExpiringIngredients(any())).thenReturn(Collections.singletonList(restaurant));
            when(emailService.findExpiringIngredientsForRestaurant(eq(2), any())).thenReturn(Collections.singletonList(ingredient));
            doNothing().when(emailService).sendExpiringIngredientsNotification(anyString(), anyString(), anyList());

            // Εκτέλεση
            ResponseEntity<String> response = emailController.sendExpiringIngredientsEmail();
    
            // Έλεγχος
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals("Emails sent successfully.", response.getBody());
            verify(emailService, times(1)).sendExpiringIngredientsNotification("stella.panopoulou678@gmail.com", "Expiring Ingredients: ", Arrays.asList(ingredient));
        }
    }
    