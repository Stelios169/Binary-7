package com.example.demo.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RestaurantDishes {
    @EmbeddedId
    private RDId id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", insertable = false, updatable = false)
    private Restaurant restaurant;
    @ManyToOne
    @JoinColumn(name = "dish_id", insertable = false, updatable = false)
    private Dish dish;
    public RestaurantDishes(RDId id, Restaurant restaurant, Dish dish) {
        this.id = id;;
        this.restaurant = restaurant;
        this.dish = dish;
    }
}

    

