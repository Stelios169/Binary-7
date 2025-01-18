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
