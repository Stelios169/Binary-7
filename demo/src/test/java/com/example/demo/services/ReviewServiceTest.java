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

import com.example.demo.controllers.ReviewController;
import com.example.demo.models.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class ReviewControllerTest {
/* 
    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private ReviewController reviewController;

    @Mock
    private Model model;

    private Review review1;
    private Review review2;

    @BeforeEach
    void setUp() {
        review1 = new Review(1, "Amazing!", 5.0);
        review2 = new Review(2, "Not bad.", 3.5);
    }

    @Test
    void testGetReviewsByRestaurant() {
        // Mock the service call
        when(reviewService.getReviewsByRestaurant(1)).thenReturn(Arrays.asList(review1, review2));

        String viewName = reviewController.getReviewsByRestaurant(1, model);
        assertEquals("reviewList", viewName);
    }

    @Test
    void testAddReview() {
        // Mock the service behavior
        when(reviewService.addReview(any(Review.class), eq(1))).thenReturn(review1);
        when(reviewService.getReviewsByRestaurant(1)).thenReturn(Arrays.asList(review1, review2));

        String viewName = reviewController.addReview(review1, 1, model);
        assertEquals("reviewList", viewName);
    }*/
}
