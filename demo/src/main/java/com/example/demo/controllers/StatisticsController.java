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

package com.example.demo.controllers;

import java.util.List;
import com.example.demo.statistics.dto.FavoriteDishDTO;
import com.example.demo.statistics.dto.DishCostDTO;
import com.example.demo.statistics.dto.DishProfitDTO;
import com.example.demo.statistics.dto.SalesDTO;
import com.example.demo.statistics.dto.TotalProfitDTO;
import com.example.demo.models.Review;
import com.example.demo.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.models.Ingredient;

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

    @GetMapping("/tables")
    public String getPurchaseTime(@RequestParam(defaultValue = "1") int restaurant_id, Model model) {
        List<Ingredient> ingredients = dishService.getIngredients(restaurant_id);
        model.addAttribute("restaurant_id", restaurant_id);
        model.addAttribute("ingredients", ingredients);
        return "tables";
    }

}
