package com.example.demo.statistics.dto;
 
public class DishCostDTO {
    private String dish_name;
    private Double dishCost;
 
    public DishCostDTO(String dish_name, Double dishCost) {
        this.dish_name = dish_name;
        this.dishCost = dishCost;
    }
 
    public String getDishName() {
        return dish_name;
    }
 
    public void setDishName(String dish_name) {
        this.dish_name = dish_name;
    }
 
    public Double getDishCost() {
        return dishCost;
    }
 
    public void setDishCost(Double dishCost) {
        this.dishCost = dishCost;
    }
}

 
    
