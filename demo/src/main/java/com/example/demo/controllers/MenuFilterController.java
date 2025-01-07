package com.example.demo.controllers;

import com.example.demo.models.Dish;
import com.example.demo.services.MenuFilterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuFilterController {

    private final MenuFilterService menuFilterService;

    public MenuFilterController(MenuFilterService menuFilterService) {
        this.menuFilterService = menuFilterService;
    }

    @GetMapping("/view")
    public Map<String, List<Dish>> viewMenu() {
        return menuFilterService.viewMenu();
    }

    @PostMapping("/filter")
    public List<Dish> filterMenu(@RequestParam double budget,
                                 @RequestParam String[] categories,
                                 @RequestParam String[] allergies) {
        return menuFilterService.filterMenu(budget, categories, allergies);
    }
}
