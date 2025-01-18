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

 package com.example.demo.models;

 import jakarta.persistence.*;
 import lombok.Data;
 import lombok.NoArgsConstructor;
 
 @Entity
 @Data
 @NoArgsConstructor
 @Table(name = "Review", schema = "Progr")
 public class Review {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int review_id;
     private String review_comment;
     private double review_rating;
 
     public Review(int review_id, String review_comment, double review_rating) {
         this.review_comment = review_comment;
         this.review_id = review_id;
         this.review_rating = review_rating;
     }
 
     @ManyToOne
     @JoinColumn(name = "restaurant_id")
     private Restaurant restaurant;
 
     // Getters and Setters
     public int getReview_id() {
         return review_id;
     }
 
     public void setReview_id(int review_id) {
         this.review_id = review_id;
     }
 
     public String getReviewComment() {
         return review_comment;
     }
 
     public void setReviewComment(String review_comment) {
         this.review_comment = review_comment;
     }
 
     public double getReviewRating() {
         return review_rating;
     }
 
     public void setReviewRating(double review_rating) {
         this.review_rating = review_rating;
     }
 
     public String getRestaurant() {
         return restaurant.getRestaurant_name();
     }
 
     public void setRestaurant(Restaurant restaurant) {
         this.restaurant = restaurant;
     }
 }
