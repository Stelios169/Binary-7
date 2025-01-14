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
