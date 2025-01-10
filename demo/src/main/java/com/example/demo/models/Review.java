package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
