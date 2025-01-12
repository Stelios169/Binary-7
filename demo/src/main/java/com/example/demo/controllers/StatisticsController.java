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

    // Endpoint για αγαπημένο πιάτο εβδομαδιαιώς
    // @GetMapping("/statistics")
    // public List<FavoriteDishDTO> getFavoriteDish() {
    // return dishService.getFavoriteDishForLastMonth();
    // }
    @GetMapping("/statistics")
    public String getFavoriteDishPage(Model model) {
        List<FavoriteDishDTO> favoriteDishes = dishService.getFavoriteDishForLastMonth();
        model.addAttribute("favoriteDishes", favoriteDishes);
        return "statistics"; // Το όνομα του Thymeleaf template
    }
}

// Endpoint για το κόστος πιάτου
// @GetMapping("/statistics")
// public List<DishCostDTO> getDishCost() {
// return dishService.getDishCost();
// }

// // Endpoint για το κέρδος πιάτου
// @GetMapping("/statistics")
// public List<DishProfitDTO> getDishProfit() {
// return dishService.getDishProfit();
// }

// // Endpoint για πωλήσεις ανά πιάτο
// @GetMapping("/statistics")
// public List<SalesDTO> getDishSales() {
// return dishService.getDishSales();
// }

// // Endpoint για το συνολικό κέρδος μηνιαίως
// @GetMapping("/statistics")
// public List<TotalProfitDTO> getMonthlyTotalProfit() {
// return dishService.getMonthlyTotalProfit();
// }

// // Endpoint για το συνολικό κέρδος ετησίως
// @GetMapping("/statistics")
// public List<TotalProfitDTO> getAnnualTotalProfit() {
// return dishService.getAnnualTotalProfit();
// }
// }
