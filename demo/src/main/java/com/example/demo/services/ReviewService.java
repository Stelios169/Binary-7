package com.example.demo.services;

import com.example.demo.models.Review;
import com.example.demo.models.Restaurant;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.repositories.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewService(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Review> getReviewsByRestaurant(int restaurant_id) {
        return reviewRepository.findByRestaurant_RestaurantId(restaurant_id);
    }

    public Review addReview(Review review, int restaurant_id) {
        Restaurant restaurant = restaurantRepository.findById(restaurant_id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found with id " + restaurant_id));
        review.setRestaurant(restaurant);
        return reviewRepository.save(review);
    }
}