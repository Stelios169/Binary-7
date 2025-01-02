package com.example.demo.models;

import jakarta.persistence.CascadeType;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    public Orders(int order_id, double order_total, boolean order_status) {
        this.order_id = order_id;
        this.order_total = order_total;
        this.order_status = order_status;
    } 
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id"),
        @JoinColumn(name = "table_id", referencedColumnName = "table_id")
    })
    private RTable table;  
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderPerDish> dishes = new ArrayList<>(); 
}
