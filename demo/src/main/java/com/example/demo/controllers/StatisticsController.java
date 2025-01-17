package com.example.demo.controllers;

import java.util.List;
import com.example.demo.statistics.dto.FavoriteDishDTO;
import com.example.demo.statistics.dto.DishCostDTO;
import com.example.demo.statistics.dto.DishProfitDTO;
import com.example.demo.statistics.dto.SalesDTO;
import com.example.demo.statistics.dto.TotalProfitDTO;
import com.example.demo.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/login")

public class StatisticsController {
    @Autowired
    private DishService dishService;

    @GetMapping("/statistics")
    public String getAllStatistics(Model model) {
        model.addAttribute("favoriteDishes", getFavoriteDishForMonth());
        model.addAttribute("favoriteDishes2", getFavoriteDishForWeek());
        model.addAttribute("dishCost", getDishCost());
        model.addAttribute("dishProfit", getDishProfit());
        model.addAttribute("sales", getSales());
        model.addAttribute("totalProfit", getMonthlyProfit());
        model.addAttribute("totalProfit2", getAnnualProfit());
        return "statistics";
    }

    // Ξεχωριστές μέθοδοι για κάθε λειτουργία
    private FavoriteDishDTO getFavoriteDishForMonth() {
       return dishService.getFavoriteDishForLastMonth();
        }
    

    private FavoriteDishDTO getFavoriteDishForWeek() {
        return dishService.getFavoriteDishForLastWeek();
    }

    private List<DishCostDTO> getDishCost() {
        return dishService.getDishCost();
    }

    private List<DishProfitDTO> getDishProfit() {
        return dishService.getDishProfit();
    }

    private List<SalesDTO> getSales() {
        return dishService.getDishSales();
    }

    private List<TotalProfitDTO> getMonthlyProfit() {
        return dishService.getMonthlyTotalProfit();
    }

    private List<TotalProfitDTO> getAnnualProfit() {
        return dishService.getAnnualTotalProfit();
    }
}
