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
    @JoinColumn(name = "ingredient_id", insertable = false, updatable = false)
    private Ingredient ingredient;
    @ManyToOne
    @JoinColumn(name = "dish_id", insertable = false, updatable = false)
    private Dish dish;
    private int ingredient_quantity; // Επιπλέον γνώρισμα
    public DishIngredients(DId id, Ingredient ingredient, Dish dish, int ingredient_quantity) {
        this.id = id;
        this.ingredient = ingredient;
        this.dish = dish;
        this.ingredient_quantity = ingredient_quantity;
    }
}
