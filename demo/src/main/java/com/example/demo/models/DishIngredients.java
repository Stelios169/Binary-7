/*
 * Copyright 2024-2025 Binary 7
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;

@ToString(onlyExplicitlyIncluded = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "Dishingredients", schema = "Progr")
public class DishIngredients {
    @EmbeddedId
    private DId id;
    
    @ToString.Exclude
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
