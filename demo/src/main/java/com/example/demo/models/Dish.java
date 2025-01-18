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
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Dish", schema = "Progr")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int dish_id;
    private String dish_name; // Τίτλος συνταγής (π.χ. "Cake")
    private double dish_price;
    private String dish_category;
    private String dish_image_url;
    private String dish_description;
    private boolean dish_availability;
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestaurantDishes> restaurantDishes = new ArrayList<>();
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderPerDish> orders = new ArrayList<>();
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DishIngredients> ingredients = new ArrayList<>();
    @Transient
    private double score; // Σκορ προτεραιότητας πιάτων

    public Dish(String dish_name, int dish_id, double dish_price, String dish_category, String dish_description,
            boolean dish_availability, String dish_image_url) {
        this.dish_name = dish_name;
        this.dish_id = dish_id;
        this.dish_category = dish_category;
        this.dish_price = dish_price;
        this.dish_description = dish_description;
        this.dish_availability = dish_availability;
        this.dish_image_url = dish_image_url;
    }

    // Getters and Setters
    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public double getDish_price() {
        return dish_price;
    }

    public void setDishPrice(double dish_price) {
        if (dish_price <= 0) {
            throw new IllegalArgumentException("Η τιμή του πιάτου πρέπει να είναι μεγαλύτερη από 0.");
        }
        this.dish_price = dish_price;
    }

    public String getDish_category() {
        return dish_category;
    }

    public void setDish_category(String dish_category) {
        this.dish_category = dish_category;
    }

    public String getDish_image_url() {
        return dish_image_url;
    }

    public void setDish_image_url(String dish_image_url) {
        this.dish_image_url = dish_image_url;
    }

    public String getDish_description() {
        return dish_description;
    }

    public void setDish_description(String dish_description) {
        this.dish_description = dish_description;
    }

    public boolean isDish_availability() {
        return dish_availability;
    }

    public void setDish_availability(boolean dish_availability) {
        this.dish_availability = dish_availability;
    }

    public List<RestaurantDishes> getRestaurantDishes() {
        return restaurantDishes;
    }

    public void setRestaurantDishes(List<RestaurantDishes> restaurantDishes) {
        this.restaurantDishes = restaurantDishes;
    }

    public List<OrderPerDish> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderPerDish> orders) {
        this.orders = orders;
    }

    public List<DishIngredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<DishIngredients> ingredients) {
        this.ingredients = ingredients;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
