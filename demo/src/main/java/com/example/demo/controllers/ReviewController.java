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

import com.example.demo.models.Restaurant;
import com.example.demo.models.Review;
import com.example.demo.repositories.RestaurantRepository;
import com.example.demo.services.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// @RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;

    }

    @GetMapping("/reviewList")
    public String getReviewsByRestaurant(@RequestParam(defaultValue = "1") int restaurant_id, Model model) {
        List<Review> reviews = reviewService.getReviewsByRestaurant(restaurant_id);
        model.addAttribute("restaurant_id", restaurant_id);
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new Review());
        return "reviewList";
    }

    @PostMapping("/reviewList")
    public String addReview(@ModelAttribute Review review, @RequestParam int restaurant_id,
            Model model) {

        Review savedReview = reviewService.addReview(review, restaurant_id);
        List<Review> reviews = reviewService.getReviewsByRestaurant(restaurant_id);
        model.addAttribute("restaurant_id", restaurant_id);
        model.addAttribute("review", savedReview);
        model.addAttribute("reviews", reviews);
        return "reviewList";
    }
}