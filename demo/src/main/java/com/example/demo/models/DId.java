package com.example.demo.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;
import lombok.Data;

@Embeddable
@NoArgsConstructor
@Data 
public class DId implements Serializable {
    private int ingredient_id;
    private int dish_id; 
}
