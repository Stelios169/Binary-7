package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor

public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int purchase_id;
    private double purchase_quantity;
    private LocalDate purchase_date;
    @ManyToOne
    @JoinColumn(name = "IngredientId")
    private Ingredient ingredient;
    public Purchase(int purchase_id, double purchase_quantity, LocalDate purchase_date) {
        this.purchase_id = purchase_id;
        this.purchase_quantity = purchase_quantity;
        this.purchase_date = purchase_date;
    }      
}
