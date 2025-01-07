package com.example.demo.statistics.dto;

public class FavoriteDishDTO {
    private String dish_name;

    public FavoriteDishDTO(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getDishName() {
        return dish_name;
    }

    public void setDishName(String dish_name) {
        this.dish_name = dish_name;
    }
}
