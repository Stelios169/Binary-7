package com.example.demo.statistics.dto;

public class AvgRestockTimeDTO {
    private Double avgRestockTime;

    public AvgRestockTimeDTO(Double avgRestockTime) {
        this.avgRestockTime = avgRestockTime;
    }

    public Double getAvgRestockTime() {
        return avgRestockTime;
    }

    public void setAvgRestockTime(Double avgRestockTime) {
        this.avgRestockTime = avgRestockTime;
    }
}
