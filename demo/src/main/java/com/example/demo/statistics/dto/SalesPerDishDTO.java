package com.example.demo.statistics.dto;

public class SalesPerDishDTO {
    private String dish_name;
    private Double sales;

    public SalesPerDishDTO(String dish_name, Double sales) {
        this.dish_name = dish_name;
        this.sales = sales;
    }

    public String getDishName() {
        return dish_name;
    }

    public void setDishName(String dish_name) {
        this.dish_name = dish_name;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

}
