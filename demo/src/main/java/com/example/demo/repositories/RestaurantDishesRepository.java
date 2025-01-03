package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.RDId;
import com.example.demo.models.RestaurantDishes;

public interface RestaurantDishesRepository extends JpaRepository<RestaurantDishes, RDId>{
    
}
