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
