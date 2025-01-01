package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import com.example.demo.services.ReviewService;
import com.example.demo.models.Review;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable int id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @PutMapping("/{id}")
    public Review editReview(@PathVariable int id, @RequestParam int newRating, @RequestParam String newComment) {
        return reviewService.editReview(id, newRating, newComment);
    }

    @DeleteMapping("/{id}")
    public void removeReview(@PathVariable int id) {
        reviewService.removeReview(id);
    }
}
