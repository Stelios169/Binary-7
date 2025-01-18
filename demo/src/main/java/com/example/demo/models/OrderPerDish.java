/*
 * Copyright 2024-2025 Binary 7
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
@Table(name = "Orderperdish", schema = "Progr")
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
