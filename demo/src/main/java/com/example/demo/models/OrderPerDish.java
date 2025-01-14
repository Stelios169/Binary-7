package com.example.demo.models;
 

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
@Table(name = "OrderPerDish", schema = "Progr")
public class OrderPerDish {
    @EmbeddedId
    private DOid id;
    
    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    private Orders order;
    
    @ManyToOne
    @MapsId("dish_id")
    @JoinColumn(name = "dish_id", referencedColumnName = "dish_id", insertable = false, updatable = false)
    private Dish dish;

    @Column(name = "orderPerDish_quantity")
    private int orderPerDish_quantity; // Επιπλέον γνώρισμα
    
    // Getters and Setters
    public DOid getId() {
        return id;
    }

    public void setId(DOid id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getOrderPerDish_quantity() {
        return orderPerDish_quantity;
    }

    public void setOrderPerDish_quantity(int orderPerDish_quantity) {
        this.orderPerDish_quantity = orderPerDish_quantity;
    }
}
