package com.example.demo.repositories;

import com.example.demo.models.OrderPerDish;
import com.example.demo.models.DOid;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface OrderPerDishRepository extends JpaRepository<OrderPerDish, DOid> {
   
}
 
