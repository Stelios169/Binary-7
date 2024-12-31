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
}
