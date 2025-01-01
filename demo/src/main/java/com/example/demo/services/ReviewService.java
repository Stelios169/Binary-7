package com.example.demo.services;

import com.example.demo.repositories.*;
import org.springframework.stereotype.Service;
import com.example.demo.models.Review;
import java.util.List;
import java.util.Optional;
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public Review addReview(Review review) {
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
