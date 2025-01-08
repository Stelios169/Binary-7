package com.example.demo.statistics.dto;


public class FavoriteDishDTO {
    private String dish_name;
    private Long totalQuantity;
     
    public FavoriteDishDTO(String dish_name, Long totalQuantity) {
        this.dish_name = dish_name;
        this.totalQuantity = totalQuantity;
       
    }
     
    public String getDishName() {
        return dish_name;
    }
     
    public void setDishName(String dish_name) {
        this.dish_name = dish_name;
    }
     
    public Long getTotalQuantity() {
        return totalQuantity;
    }
     
    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    
}
