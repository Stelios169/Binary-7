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

 import com.example.demo.models.Review;
 import com.example.demo.models.Restaurant;
 import com.example.demo.repositories.ReviewRepository;
 import com.example.demo.repositories.RestaurantRepository;
 import jakarta.persistence.EntityNotFoundException;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
 import org.mockito.Mock;
 import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
 import java.util.Optional;
 
 import static org.mockito.Mockito.*;
 import static org.junit.jupiter.api.Assertions.*;
 
 @ExtendWith(MockitoExtension.class)
 public class ReviewServiceTest {
 
     @Mock
     private ReviewRepository reviewRepository;
 
     @Mock
     private RestaurantRepository restaurantRepository;
 
     @InjectMocks
     private ReviewService reviewService;
 
     private Restaurant restaurant;
     private Review review;
 
     @BeforeEach
     void setUp() {
                  restaurant = new Restaurant(3, "1234hi", "Test Restaurant", "New York", "Italian@gmail.com", 5, 1234567, 1234567);
                  restaurant.setRestaurant_id(1);
                  restaurant.setRestaurant_name("Test Restaurant");
          
                  review = new Review(1, "Great food!", 5);
                  review.setReview_id(1);
                  review.setReviewRating(5);
                  review.setReviewComment("Great food!");
              }
          
              private Restaurant Restaurant(int i, String string, String string2, String string3, String string4, int j, int k) {
                 throw new UnsupportedOperationException("Unimplemented method 'Restaurant'");
              }
         
             @Test
     void testGetReviewsByRestaurant() {
         // Arrange
         when(reviewRepository.findByRestaurant_RestaurantId(1)).thenReturn(List.of(review));
 
         // Act
         List<Review> reviews = reviewService.getReviewsByRestaurant(1);
 
         // Assert
         assertEquals(1, reviews.size());
         assertEquals("Great food!", reviews.get(0).getReviewComment());
         verify(reviewRepository, times(1)).findByRestaurant_RestaurantId(1);
     }
 
     @Test
     void testAddReview() {
         // Arrange
         when(restaurantRepository.findById(1)).thenReturn(Optional.of(restaurant));
         when(reviewRepository.save(review)).thenReturn(review);
 
         // Act
         Review savedReview = reviewService.addReview(review, 1);
 
         // Assert
         assertNotNull(savedReview);
         assertEquals("Great food!", savedReview.getReviewComment());
         verify(restaurantRepository, times(1)).findById(1);
         verify(reviewRepository, times(1)).save(review);
     }
 
     @Test
     void testAddReview_RestaurantNotFound() {
         // Arrange
         when(restaurantRepository.findById(1)).thenReturn(Optional.empty());
 
         // Act & Assert
         assertThrows(EntityNotFoundException.class, () -> reviewService.addReview(review, 1));
     }
 }
 