package com.example.demo.services;

import com.example.demo.repositories.ReviewRepository;
import com.example.demo.models.Review;
import com.example.demo.models.Restaurant;
import com.example.demo.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewService(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public Review addReview(Review review, int restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        review.setRestaurant(restaurant);
        return reviewRepository.save(review);
    }

    public Review editReview(int reviewId, int newRating, String newComment) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            review.setReviewRating(newRating);
            review.setReviewComment(newComment);
            return reviewRepository.save(review);
        }
        throw new RuntimeException("Review not found with id " + reviewId);
    }

    public void removeReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}

