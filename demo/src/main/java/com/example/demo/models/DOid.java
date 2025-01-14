package com.example.demo.models;

import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DOid dOid = (DOid) o;
        return Objects.equals(dish_id, dOid.dish_id) && Objects.equals(order_id, dOid.order_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dish_id, order_id);
    }
}
