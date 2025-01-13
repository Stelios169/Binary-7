package com.example.demo.controllers;

import com.example.demo.models.Review;
import com.example.demo.services.ReviewService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "reviewList";
    }

    @PostMapping
    public String addReview(@RequestBody Review review, @RequestParam int restaurantId, Model model) {
        Review addedReview = reviewService.addReview(review, restaurantId);
        model.addAttribute("review", addedReview);
        return "reviewAdded";
    }

    @PutMapping("/{id}")
    public String editReview(@PathVariable int id, @RequestParam int newRating, @RequestParam String newComment, Model model) {
        Review updatedReview = reviewService.editReview(id, newRating, newComment);
        model.addAttribute("review", updatedReview);
        return "reviewEdited"; 
    }

    @DeleteMapping("/{id}")
    public String removeReview(@PathVariable int id, Model model) {
        reviewService.removeReview(id);
        model.addAttribute("message", "Review removed successfully.");
        return "reviewRemoved"; 
    }
}
