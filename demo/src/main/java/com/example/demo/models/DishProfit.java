package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DishProfit {
    private int dishId;
    private String dishName;
    private int restaurantId;
    private float price;
    private float cost;
    private float profit;
    private String categoryName;
}
