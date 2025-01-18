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
            Ingredient ingredient = new Ingredient(1, "Tomato", 2.5, "Vegetable", 0.5, LocalDate.now());
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
    