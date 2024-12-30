package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Dish;
 
public interface DishRepository extends JpaRepository<Dish, > {
   
}
