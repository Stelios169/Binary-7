package com.example.demo.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Ingredient", schema = "Progr")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredient_id;
    private String ingredient_name; // Όνομα υλικού (π.χ. "flour")
    private double ingredient_stock; // Διαθέσιμη ποσότητα (π.χ. 200 γραμμάρια)
    private double ingredient_cost;
    private String ingredient_unit;
    private LocalDate ingredient_exp_date;
    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DishIngredients> dishIngredients = new ArrayList<>();
    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purchase> purchase = new ArrayList<>();
    public Ingredient(String ingredient_name, double ingredient_stock, int ingredient_id, double ingredient_cost, String ingredient_unit, LocalDate ingredient_exp_date) {
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
