package com.example.demo.models;
 

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
public class OrderPerDish {
    @EmbeddedId
    private DOid id;
    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_Id")
    private Orders order;
    @ManyToOne
    @MapsId("dish_id")
    @JoinColumn(name = "dish_Id")
    private Dish dish;
    private int orderPerDish_quantity; // Επιπλέον γνώρισμα
    
    
}
