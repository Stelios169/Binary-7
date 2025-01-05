package com.example.demo.models;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Embeddable
@Data
public class TId implements Serializable {
    private int table_id;
    private int restaurant_id;

    public TId(int table_id, int restaurant_id) {
        this.table_id = table_id;
        this.restaurant_id = restaurant_id;
    }
}
