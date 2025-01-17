package com.example.demo.controllers;

import com.example.demo.services.DishService;
import com.example.demo.statistics.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StatisticsControllerTest {

    @Mock
    private DishService dishService;

    @Mock
    private Model model;

    @InjectMocks
    private StatisticsController statisticsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStatistics() {
        FavoriteDishDTO mockFavoriteDishMonth = new FavoriteDishDTO("Pizza", 50L);
        FavoriteDishDTO mockFavoriteDishWeek = new FavoriteDishDTO("Sushi", 30L);

        List<DishCostDTO> mockDishCost = Arrays.asList(
                new DishCostDTO("Pizza", 10.0),
                new DishCostDTO("Burger", 8.0)
        );

        List<DishProfitDTO> mockDishProfit = Arrays.asList(
                new DishProfitDTO("Pizza", 20.0),
                new DishProfitDTO("Burger", 15.0)
        );

        List<SalesDTO> mockSales = Arrays.asList(
                new SalesDTO("Pizza", 200L),
                new SalesDTO("Burger", 150L)
        );

        List<TotalProfitDTO> mockMonthlyProfit = Arrays.asList(
                new TotalProfitDTO("January", 5000.0),
                new TotalProfitDTO("February", 4500.0)
        );

        List<TotalProfitDTO> mockAnnualProfit = Arrays.asList(
                new TotalProfitDTO("2024", 60000.0)
        );

        when(dishService.getFavoriteDishForLastMonth()).thenReturn(mockFavoriteDishMonth);
        when(dishService.getFavoriteDishForLastWeek()).thenReturn(mockFavoriteDishWeek);
        when(dishService.getDishCost()).thenReturn(mockDishCost);
        when(dishService.getDishProfit()).thenReturn(mockDishProfit);
        when(dishService.getDishSales()).thenReturn(mockSales);
        when(dishService.getMonthlyTotalProfit()).thenReturn(mockMonthlyProfit);
        when(dishService.getAnnualTotalProfit()).thenReturn(mockAnnualProfit);

        String viewName = statisticsController.getAllStatistics(model);

        assertEquals("statistics", viewName);

        verify(model, times(1)).addAttribute("favoriteDishes", mockFavoriteDishMonth);
        verify(model, times(1)).addAttribute("favoriteDishes2", mockFavoriteDishWeek);
        verify(model, times(1)).addAttribute("dishCost", mockDishCost);
        verify(model, times(1)).addAttribute("dishProfit", mockDishProfit);
        verify(model, times(1)).addAttribute("sales", mockSales);
        verify(model, times(1)).addAttribute("totalProfit", mockMonthlyProfit);
        verify(model, times(1)).addAttribute("totalProfit2", mockAnnualProfit);
    }
}
