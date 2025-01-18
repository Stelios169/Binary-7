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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ReviewControllerTest {

    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private ReviewController reviewController;

    private MockMvc mockMvc;

    @Mock
    private Review review;

    @BeforeEach
    void setUp() {
        // Ορίζουμε τον ViewResolver για τις δοκιμές
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(reviewController)
                .setViewResolvers(viewResolver)
                .build();

        review = new Review(1, "Great food!", 5.0);
        review.setReview_id(1);
        review.setReviewRating(5.0);
        review.setReviewComment("Great food!");
    }

    @Test
    void testGetReviewsByRestaurant() throws Exception {
        // Arrange
        when(reviewService.getReviewsByRestaurant(1)).thenReturn(List.of(review));

        // Act & Assert
        mockMvc.perform(get("/reviewList?restaurant_id=1"))
            .andExpect(status().isOk())
            .andExpect(view().name("reviewList"))
            .andExpect(model().attributeExists("reviews"))
            .andExpect(model().attribute("reviews", List.of(review)));
    }

    @Test
    void testAddReview() throws Exception {
        // Arrange
        when(reviewService.addReview(any(Review.class), eq(1))).thenReturn(review);
        when(reviewService.getReviewsByRestaurant(1)).thenReturn(List.of(review));

        // Act & Assert
        mockMvc.perform(post("/reviewList")
            .param("restaurant_id", "1")
            .flashAttr("review", review))
            .andExpect(status().isOk())
            .andExpect(view().name("reviewList"))
            .andExpect(model().attribute("reviews", List.of(review)));
    } 
}
