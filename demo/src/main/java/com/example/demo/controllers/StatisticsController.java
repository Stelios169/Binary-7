package com.example.demo.controllers;

import java.util.List;
import com.example.demo.statistics.dto.FavoriteDishDTO;
import com.example.demo.statistics.dto.DishCostDTO;
import com.example.demo.statistics.dto.DishProfitDTO;
import com.example.demo.statistics.dto.SalesDTO;
import com.example.demo.statistics.dto.TotalProfitDTO;
import com.example.demo.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/statistics")

public class StatisticsController {
    @Autowired
    private DishService dishService;
     
    // Endpoint για αγαπημένο πιάτο εβδομαδιαιώς
    @GetMapping("/favoriteDish")
    public List<FavoriteDishDTO> getFavoriteDish() {
        return dishService.getFavoriteDishForLastMonth();
    }
     
    // Endpoint για το κόστος πιάτου
    @GetMapping("/cost")
    public List<DishCostDTO> getDishCost() {
        return dishService.getDishCost();
    }
     
    // Endpoint για το κέρδος πιάτου
    @GetMapping("/profit")
    public List<DishProfitDTO> getDishProfit() {
        return dishService.getDishProfit();
    }
     
        // Endpoint για πωλήσεις ανά πιάτο
    @GetMapping("/sales")
    public List<SalesDTO> getDishSales() {
        return dishService.getDishSales();
    }
     
        // Endpoint για το συνολικό κέρδος μηνιαίως
    @GetMapping("/profitmonthly")
    public List<TotalProfitDTO> getMonthlyTotalProfit() {
        return dishService.getMonthlyTotalProfit();
    }
    // Endpoint για το συνολικό κέρδος ετησίως
    @GetMapping("/profitannual")
    public List<TotalProfitDTO> getAnnualTotalProfit() {
        return dishService.getAnnualTotalProfit();
    }
}

