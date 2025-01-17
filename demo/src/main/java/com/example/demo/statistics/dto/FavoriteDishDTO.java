package com.example.demo.statistics.dto;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteDishDTO that = (FavoriteDishDTO) o;
        return Objects.equals(dish_name, that.dish_name) && Objects.equals(totalQuantity, that.totalQuantity);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(dish_name, totalQuantity);
    }
    
}
