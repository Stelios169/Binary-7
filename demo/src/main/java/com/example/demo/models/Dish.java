package com.example.demo.models;

import jakarta.persistence.*; 
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private double score; //Σκορ προτεραιότητας πιάτων
    public Dish(String dish_name, int dish_id, double dish_price, String dish_category, String dish_description, boolean dish_availability, String dish_image_url) {
        this.dish_name = dish_name;
        this.dish_id = dish_id;
        this.dish_category = dish_category;
        this.dish_price = dish_price;
        this.dish_description = dish_description;
        this.dish_availability = dish_availability;
        this.dish_image_url = dish_image_url;
    }
    /**
     * Υπολογισμός του συνολικού κόστους των υλικών.
     * @return το συνολικό κόστος παραγωγής του πιάτου
     */
    public double calculateTotalCost() {
        return ingredients.stream()
                .mapToDouble(ingredient -> ingredient.getIngredient_quantity() * ingredient.getIngredient().getIngredient_cost())
                .sum();
    }

    /**
     * Ενημέρωση του score του πιάτου.
     */
    @PrePersist
    @PreUpdate
    public void updateScore() {
        double totalCost = calculateTotalCost();
        double profit = this.dish_price - totalCost;
        this.score = profit; // Υπολογισμός του σκορ
    }
}
