package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "RTable", schema = "Progr")
public class RTable {

    @EmbeddedId
    private TId tableId;

    @ManyToOne
    @MapsId("restaurant_id")
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    
    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();

    // Getters and Setters
    public TId getTableId() {
        return tableId;
    }

    public void setTableId(TId tableId) {
        this.tableId = tableId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
