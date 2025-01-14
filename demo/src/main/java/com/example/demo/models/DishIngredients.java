package com.example.demo.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
@Table(name = "DishIngredients", schema = "Progr")
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

    // Προσθήκη Getter και Setter για ingredient
    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    // Προσθήκη Getter και Setter για dish
    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    // Προσθήκη Getter και Setter για ingredient_quantity
    public int getIngredient_quantity() {
        return ingredient_quantity;
    }

    public void setIngredient_quantity(int ingredient_quantity) {
        this.ingredient_quantity = ingredient_quantity;
    }
}
