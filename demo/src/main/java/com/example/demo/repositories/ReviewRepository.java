package com.example.demo.repositories;

import com.example.demo.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface ReviewRepository extends JpaRepository<Review, Integer> {
   
}
