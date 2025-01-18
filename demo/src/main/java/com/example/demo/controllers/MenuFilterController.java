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

import com.example.demo.models.Dish;
import com.example.demo.services.MenuFilterService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/menu")
public class MenuFilterController {
    private final MenuFilterService menuFilterService;

    public MenuFilterController(MenuFilterService menuFilterService) {
        this.menuFilterService = menuFilterService;
    }

    // Μέθοδος για την εμφάνιση του μενού ταξινομημένου

    // Μέθοδος για το φιλτράρισμα του μενού με βάση τον προϋπολογισμό, κατηγορίες
    // και αλλεργιογόνα
    @GetMapping("/menu")
    public String filterMenu(@RequestParam(required = false) Double budget,
            @RequestParam(required = false) String[] categories,
            @RequestParam(required = false) String[] allergies,
            Model model) {

        List<Dish> filteredDishes = menuFilterService.filterMenu(budget != null ? budget : Double.MAX_VALUE);

        if (categories != null && categories.length > 0) {
            filteredDishes = menuFilterService.filterByCategory(categories);
        }

        if (allergies != null && allergies.length > 0) {
            filteredDishes = menuFilterService.filterByAllergens(allergies);
        }

        // if (budget != null) {
        // filteredDishes = filteredDishes.stream()
        // .filter(dish -> dish.getDish_price() <= budget)
        // .collect(Collectors.toList());
        // }

        // if (categories != null && categories.length > 0) {
        // filteredDishes = filteredDishes.stream()
        // .filter(dish -> Arrays.asList(categories).contains(dish.getDish_category()))
        // .collect(Collectors.toList());
        // }

        // if (allergies != null && allergies.length > 0) {
        // filteredDishes = filteredDishes.stream()
        // .filter(dish -> Arrays.stream(allergies)
        // .noneMatch(allergy -> dish.getIngredients().contains(allergy)))
        // .collect(Collectors.toList());
        // }
        // Προσθήκη των φίλτρων στο μοντέλο για την προβολή
        model.addAttribute("filteredDishes", filteredDishes);
        return "menu";
    }
}
