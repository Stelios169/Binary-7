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

    @GetMapping("/view")
    public String viewMenu(Model model) {
        Map<String, List<Dish>> menu = menuFilterService.viewMenu();
        model.addAttribute("menu", menu);
        return "menuView";
    }

    @GetMapping("/menu")
    public String filterMenu(@RequestParam double budget,
            @RequestParam String[] categories,
            @RequestParam String[] allergies,
            Model model) {
        List<Dish> filteredDishes = menuFilterService.filterMenu(budget);
        model.addAttribute("filteredDishes", filteredDishes);
        return "menu";
    }

}
