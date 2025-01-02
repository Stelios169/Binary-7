package com.example.demo.controllers;

import com.example.demo.models.FilterRequest;
import com.example.demo.models.DishProfit;
import com.example.demo.services.MenuService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/profits")
    public List<DishProfit> calculateAndSortDishProfit() {
        return menuService.calculateAndSortDishProfit();
    }

    @GetMapping("/by-category")
    public Map<String, List<DishProfit>> displayMenuByCategory() {
        List<DishProfit> dishProfits = menuService.calculateAndSortDishProfit();
        return menuService.groupMenuByCategory(dishProfits);
    }

    @PostMapping("/filter")
    public List<DishProfit> filterMenuByUserInput(
            @RequestBody FilterRequest filterRequest) {
        List<DishProfit> dishProfits = menuService.calculateAndSortDishProfit();
        return menuService.filterMenuByUserInput(dishProfits, filterRequest.getCategory(),
                filterRequest.getMaxPrice(), filterRequest.getAllergens());
    }
}

