package com.example.demo.statistics.dto;

public class AverageStockTimeDTO {
    private String ingredientName;
    private Double averageReplenishmentTime;
 
    public AverageStockTimeDTO(String ingredientName, Double averageReplenishmentTime) {
        this.ingredientName = ingredientName;
        this.averageReplenishmentTime = averageReplenishmentTime;
    }
 
    public String getIngredientName() {
        return ingredientName;
    }
 
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
 
    public Double getAverageReplenishmentTime() {
        return averageReplenishmentTime;
    }
 
    public void setAverageReplenishmentTime(Double averageReplenishmentTime) {
        this.averageReplenishmentTime = averageReplenishmentTime;
    }
}

