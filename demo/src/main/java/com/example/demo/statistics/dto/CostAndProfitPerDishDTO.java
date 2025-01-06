package com.example.demo.statistics.dto;

public class CostAndProfitPerDishDTO {
    private String dish_name;
    private Double cost;
    private Double profit;
 
    public CostAndProfitPerDishDTO(String dish_name, Double cost, Double profit) {
        this.dish_name = dish_name;
        this.cost = cost;
        this.profit = profit;
    }
 
    public String getDishName() {
        return dish_name;
    }
 
    public void setDishName(String dish_name) {
        this.dish_name = dish_name;
    
    }
    public Double getCost() {
        return cost;
    }
 
    public void setCost(Double cost) {
        this.cost = cost;
    }
 
    public Double getProfit() {
        return profit;
    }
 
    public void setProfit(Double profit) {
        this.profit = profit;
    }
}
