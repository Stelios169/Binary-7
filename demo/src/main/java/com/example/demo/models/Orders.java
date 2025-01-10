package com.example.demo.models;

import jakarta.persistence.CascadeType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private double order_total;
    private boolean order_status;
    private LocalDateTime order_datetime;

    public Orders(int order_id, double order_total, boolean order_status, LocalDateTime order_datetime) {
        this.order_id = order_id;
        this.order_total = order_total;
        this.order_status = order_status;
        this.order_datetime = order_datetime;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id"),
            @JoinColumn(name = "table_id", referencedColumnName = "table_id")
    })
    private RTable table;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderPerDish> dishes = new ArrayList<>();

    // Getters and Setters
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(double order_total) {
        this.order_total = order_total;
    }

    public boolean isOrder_status() {
        return order_status;
    }

    public void setOrder_status(boolean order_status) {
        this.order_status = order_status;
    }

    public LocalDateTime getOrder_datetime() {
        return order_datetime;
    }

    public void setOrder_datetime(LocalDateTime order_datetime) {
        this.order_datetime = order_datetime;
    }

    public RTable getTable() {
        return table;
    }

    public void setTable(RTable table) {
        this.table = table;
    }

    public List<OrderPerDish> getDishes() {
        return dishes;
    }

    public void setDishes(List<OrderPerDish> dishes) {
        this.dishes = dishes;
    }
}
