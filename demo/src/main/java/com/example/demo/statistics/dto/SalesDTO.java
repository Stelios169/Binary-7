package com.example.demo.statistics.dto;

public class SalesDTO {
    private String dish_name;
    private Long totalSales;
 
    public SalesDTO(String dish_name, Long totalSales) {
        this.dish_name = dish_name;
        this.totalSales = totalSales;
    }
 
    public String getDishName() {
        return dish_name;
    }
 
    public void setDishName(String dish_name) {
        this.dish_name = dish_name;
    }
 
    public Long getTotalSales() {
        return totalSales;
    }
 
    public void setTotalSales(Long totalSales) {
        this.totalSales = totalSales;
    }
}
