package com.example.demo.models;

import jakarta.persistence.CascadeType;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@Data
@NoArgsConstructor

public class Orders {
    @EmbeddedId
    private OId id;
    private int order_id;
    private double order_total;
    private boolean order_status;
    public Orders(int order_id, double order_total, boolean order_status) {
        this.order_id = order_id;
        this.order_total = order_total;
        this.order_status = order_status;
    } 
   @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderPerDish> orderPerDish = new ArrayList<>();
    private RTable table;
    private LocalDate order_dateTime; 
}
