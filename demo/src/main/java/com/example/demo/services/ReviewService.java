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