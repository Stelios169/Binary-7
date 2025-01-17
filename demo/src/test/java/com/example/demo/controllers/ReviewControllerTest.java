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
    } 
}
