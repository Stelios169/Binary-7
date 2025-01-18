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

