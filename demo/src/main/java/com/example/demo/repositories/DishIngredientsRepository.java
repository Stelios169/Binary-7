package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.DId;
import com.example.demo.models.DishIngredients;

public interface DishIngredientsRepository extends JpaRepository<DishIngredients, DId> {

}
