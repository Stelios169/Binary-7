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

public class TotalProfitDTO {
    private String period;
    private Double totalProfit;
 
    public TotalProfitDTO(String period, Double totalProfit) {
        this.period = period;
        this.totalProfit = totalProfit;
    }
 
    public String getPeriod() {
        return period;
    }
 
    public void setPeriod(String period) {
        this.period = period;
    }
 
    public Double getTotalProfit() {
        return totalProfit;
    }
 
    public void setTotalProfit(Double totalProfit) {
        this.totalProfit = totalProfit;
    }
    
}
