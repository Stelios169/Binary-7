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

    @GetMapping("/statistics")
    public String getFavoriteDish2Page(Model model) {
        List<FavoriteDishDTO> favoriteDishes2 = dishService.getFavoriteDishForLastWeek();
        model.addAttribute("favoriteDishes2", favoriteDishes2);
        return "statistics"; // Το όνομα του Thymeleaf template
    }

    // Endpoint για το κόστος πιάτου
    // @GetMapping("/statistics")
    // public List<DishCostDTO> getDishCost() {
    // return dishService.getDishCost();
    // }
    @GetMapping("/statistics")
    public String getDishCostPage(Model model) {
        List<DishCostDTO> dishcost = dishService.getDishCost();
        model.addAttribute("dishCost", dishcost);
        return "statistics"; // Το όνομα του Thymeleaf template
    }

    // // Endpoint για το κέρδος πιάτου
    // @GetMapping("/statistics")
    // public List<DishProfitDTO> getDishProfit() {
    // return dishService.getDishProfit();
    // }

    @GetMapping("/statistics")
    public String getDishProfitPage(Model model) {
        List<DishProfitDTO> dishprofit = dishService.getDishProfit();
        model.addAttribute("dishprofit", dishprofit);
        return "statistics"; // Το όνομα του Thymeleaf template
    }

    // // Endpoint για πωλήσεις ανά πιάτο
    // @GetMapping("/statistics")
    // public List<SalesDTO> getDishSales() {
    // return dishService.getDishSales();
    // }

    @GetMapping("/statistics")
    public String getSalesPage(Model model) {
        List<SalesDTO> sales = dishService.getDishSales();
        model.addAttribute("sales", sales);
        return "statistics"; // Το όνομα του Thymeleaf template
    }

    // // Endpoint για το συνολικό κέρδος μηνιαίως
    // @GetMapping("/statistics")
    // public List<TotalProfitDTO> getMonthlyTotalProfit() {
    // return dishService.getMonthlyTotalProfit();
    // }

    @GetMapping("/statistics")
    public String getTotalProfitPage(Model model) {
        List<TotalProfitDTO> totalprofit = dishService.getMonthlyTotalProfit();
        model.addAttribute("totalprofit", totalprofit);
        return "statistics"; // Το όνομα του Thymeleaf template
    }

    // // Endpoint για το συνολικό κέρδος ετησίως
    // @GetMapping("/statistics")
    // public List<TotalProfitDTO> getAnnualTotalProfit() {
    // return dishService.getAnnualTotalProfit();
    // }
    // }

    @GetMapping("/statistics")
    public String getTotalProfit2Page(Model model) {
        List<TotalProfitDTO> totalprofit2 = dishService.getAnnualTotalProfit();
        model.addAttribute("totalprofit2", totalprofit2);
        return "statistics"; // Το όνομα του Thymeleaf template
    }

}

