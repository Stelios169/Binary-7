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

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;

@ToString(onlyExplicitlyIncluded = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "Ingredient", schema = "Progr")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredient_id;
    private double ingredient_stock; // Διαθέσιμη ποσότητα (π.χ. 200 γραμμάρια)
    private double ingredient_cost;
    private String ingredient_unit;
    private LocalDate ingredient_exp_date;
    @ToString.Include
    private String ingredient_name;
    @ToString.Exclude
    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DishIngredients> dishIngredients = new ArrayList<>();
    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purchase> purchase = new ArrayList<>();
    public Ingredient(int ingredient_id, String ingredient_name,  double ingredient_cost, String ingredient_unit, double ingredient_stock, LocalDate ingredient_exp_date) {
        this.ingredient_name = ingredient_name;
        this.ingredient_stock = ingredient_stock;
        this.ingredient_id = ingredient_id;
        this.ingredient_cost = ingredient_cost;
        this.ingredient_unit = ingredient_unit;
        this.ingredient_exp_date = ingredient_exp_date;
    }
    
     // Getters and Setters
     public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public double getIngredient_stock() {
        return ingredient_stock;
    }

    public void setIngredient_stock(double ingredient_stock) {
        this.ingredient_stock = ingredient_stock;
    }

    public double getIngredient_cost() {
        return ingredient_cost;
    }

    public void setIngredient_cost(double ingredient_cost) {
        this.ingredient_cost = ingredient_cost;
    }

    public String getIngredient_unit() {
        return ingredient_unit;
    }

    public void setIngredient_unit(String ingredient_unit) {
        this.ingredient_unit = ingredient_unit;
    }

    public LocalDate getIngredient_exp_date() {
        return ingredient_exp_date;
    }

    public void setIngredient_exp_date(LocalDate ingredient_exp_date) {
        this.ingredient_exp_date = ingredient_exp_date;
    }

    public List<DishIngredients> getDishIngredients() {
        return dishIngredients;
    }

    public void setDishIngredients(List<DishIngredients> dishIngredients) {
        this.dishIngredients = dishIngredients;
    }

    public List<Purchase> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Purchase> purchase) {
        this.purchase = purchase;
    }
}
