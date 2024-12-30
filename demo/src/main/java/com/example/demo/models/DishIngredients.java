package com.example.demo.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
public class DishIngredients {
    @EmbeddedId
    private DId id;
    @ManyToOne
    @JoinColumn(name = "Ingredient_Id")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "Dish_Id")
    private Dish dish;

    private int ingredient_quantity; // Επιπλέον γνώρισμα
}
    
    

