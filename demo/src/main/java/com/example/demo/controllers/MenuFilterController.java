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

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class MenuFilterController {
    private final MenuFilterService menuFilterService;

    public MenuFilterController(MenuFilterService menuFilterService) {
        this.menuFilterService = menuFilterService;
    }

    // Μέθοδος για την εμφάνιση του μενού ταξινομημένου
    @GetMapping("/view")
    public String viewMenu(Model model) {
        Map<String, List<Dish>> menu = menuFilterService.viewMenu();
        model.addAttribute("menu", menu);
        return "menuView";
    }

    // Μέθοδος για το φιλτράρισμα του μενού με βάση τον προϋπολογισμό, κατηγορίες και αλλεργιογόνα
    @GetMapping("/filter")
    public String filterMenu(@RequestParam(required = false) Double budget,
                             @RequestParam(required = false) String[] categories,
                             @RequestParam(required = false) String[] allergies,
                             Model model) {

        // Φιλτράρισμα με βάση τον προϋπολογισμό
        List<Dish> filteredDishes = menuFilterService.filterMenu(budget != null ? budget : Double.MAX_VALUE);

        // Φιλτράρισμα με βάση τις κατηγορίες, αν δίνονται
        if (categories != null && categories.length > 0) {
            filteredDishes = menuFilterService.filterByCategory(categories);
        }

        // Φιλτράρισμα με βάση τα αλλεργιογόνα, αν δίνονται
        if (allergies != null && allergies.length > 0) {
            filteredDishes = menuFilterService.filterByAllergens(allergies);
        }

        // Προσθήκη των φίλτρων στο μοντέλο για την προβολή
        model.addAttribute("filteredDishes", filteredDishes);
        return "menu";
    }
}
