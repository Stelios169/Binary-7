/*
 * Copyright 2024-2025 Binary 7
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
