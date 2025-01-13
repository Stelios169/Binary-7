package com.example.demo.models;

import lombok.Data;
import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class DOid implements Serializable {
    private int order_id;
    private int dish_id;

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public DOid(int orderId, int dishId) {
        
    }
}
