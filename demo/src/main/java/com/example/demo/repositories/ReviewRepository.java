package com.example.demo.repositories;

import com.example.demo.models.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    
    @Query("SELECT r FROM Review r WHERE r.restaurant.restaurant_id = :restaurant_id")
    List<Review> findByRestaurant_RestaurantId(@Param("restaurant_id") int restaurant_id);
}
