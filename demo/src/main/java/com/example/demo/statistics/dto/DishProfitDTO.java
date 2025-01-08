package com.example.demo.statistics.dto;

public class DishProfitDTO {
    private String dish_name;
    private Double dishProfit;
 
    public DishProfitDTO(String dish_name, Double dishProfit) {
        this.dish_name = dish_name;
        this.dishProfit = dishProfit;
    }
 
    public String getDishName() {
        return dish_name;
    }
 
    public void setDishName(String dish_name) {
        this.dish_name = dish_name;
    }
 
    public Double getDishProfit() {
        return dishProfit;
    }
 
    public void setDishProfit(Double dishProfit) {
        this.dishProfit = dishProfit;
    }
}
