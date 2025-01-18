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

import com.example.demo.models.Review;
import com.example.demo.services.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ReviewControllerTest {
/* 
    private ReviewController reviewController;
    private ReviewService reviewService;
    private Model model;

    @BeforeEach
    void setUp() {
        reviewService = mock(ReviewService.class);
        model = mock(Model.class);
        reviewController = new ReviewController(reviewService);
    }

    @Test
    void getReviewsByRestaurant() {
        List<Review> reviews = Arrays.asList(new Review(), new Review());
        when(reviewService.getReviewsByRestaurant(anyInt())).thenReturn(reviews);

        String viewName = reviewController.getReviewsByRestaurant(1, model);

        assertEquals("reviewList", viewName);
        verify(reviewService, times(1)).getReviewsByRestaurant(1);
        verify(model, times(1)).addAttribute("restaurant_id", 1);
        verify(model, times(1)).addAttribute("reviews", reviews);
        verify(model, times(1)).addAttribute("review", new Review());
    }

    @Test
    void addReview() {
        Review review = new Review();
        Review savedReview = new Review();
        when(reviewService.addReview(any(Review.class), anyInt())).thenReturn(savedReview);

        String viewName = reviewController.addReview(review, 1, model);

        assertEquals("reviewList", viewName);
        verify(reviewService, times(1)).addReview(review, 1);
        verify(reviewService, times(1)).getReviewsByRestaurant(1);
        verify(model, times(1)).addAttribute("restaurant_id", 1);
        verify(model, times(1)).addAttribute("review", savedReview);
        verify(model, times(1)).addAttribute("reviews", reviewService.getReviewsByRestaurant(1));
    } */
}
