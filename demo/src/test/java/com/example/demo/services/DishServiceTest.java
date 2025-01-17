package com.example.demo.services;

import com.example.demo.statistics.dto.*;
import com.example.demo.repositories.DishRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DishServiceTest {

    @Mock
    private DishRepository dishRepository;

    @InjectMocks
    private DishService dishService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFavoriteDishForLastMonth() {
        LocalDate expectedStartDate = LocalDate.now().minusMonths(1);
        List<FavoriteDishDTO> mockFavoriteDishes = Arrays.asList(
                new FavoriteDishDTO("Pizza", 50L),
                new FavoriteDishDTO("Burger", 40L)
        );

        when(dishRepository.findFavoriteDish(expectedStartDate)).thenReturn(mockFavoriteDishes);

        FavoriteDishDTO result = dishService.getFavoriteDishForLastMonth();

        assertEquals(mockFavoriteDishes, result);
        verify(dishRepository, times(1)).findFavoriteDish(expectedStartDate);
    }

    @Test
    void testGetFavoriteDishForLastWeek() {
        LocalDate expectedStartDate = LocalDate.now().minusWeeks(1);
        List<FavoriteDishDTO> mockFavoriteDishes = Arrays.asList(
                new FavoriteDishDTO("Sushi", 30L),
                new FavoriteDishDTO("Tacos", 25L)
        );

        when(dishRepository.findFavoriteDish(expectedStartDate)).thenReturn(mockFavoriteDishes);

        FavoriteDishDTO result = dishService.getFavoriteDishForLastWeek();

        assertEquals(mockFavoriteDishes, result);
        verify(dishRepository, times(1)).findFavoriteDish(expectedStartDate);
    }

    @Test
    void testGetDishCost() {
        List<DishCostDTO> mockDishCosts = Arrays.asList(
                new DishCostDTO("Pizza", 10.0),
                new DishCostDTO("Burger", 8.0)
        );

        when(dishRepository.findDishCost()).thenReturn(mockDishCosts);

        List<DishCostDTO> result = dishService.getDishCost();

        assertEquals(mockDishCosts, result);
        verify(dishRepository, times(1)).findDishCost();
    }

    @Test
    void testGetDishProfit() {
        List<DishProfitDTO> mockDishProfits = Arrays.asList(
                new DishProfitDTO("Pizza", 20.0),
                new DishProfitDTO("Burger", 15.0)
        );

        when(dishRepository.findDishProfit()).thenReturn(mockDishProfits);

        List<DishProfitDTO> result = dishService.getDishProfit();

        assertEquals(mockDishProfits, result);
        verify(dishRepository, times(1)).findDishProfit();
    }

    @Test
    void testGetDishSales() {
        List<SalesDTO> mockDishSales = Arrays.asList(
                new SalesDTO("Pizza", 200L),
                new SalesDTO("Burger", 150L)
        );

        when(dishRepository.findDishSales()).thenReturn(mockDishSales);

        List<SalesDTO> result = dishService.getDishSales();

        assertEquals(mockDishSales, result);
        verify(dishRepository, times(1)).findDishSales();
    }

    @Test
    void testGetMonthlyTotalProfit() {
        LocalDate expectedStartDate = LocalDate.now().withDayOfYear(1);
        List<TotalProfitDTO> mockMonthlyProfits = Arrays.asList(
                new TotalProfitDTO("January", 5000.0),
                new TotalProfitDTO("February", 4500.0)
        );

        when(dishRepository.findMonthlyTotalProfit(expectedStartDate)).thenReturn(mockMonthlyProfits);

        List<TotalProfitDTO> result = dishService.getMonthlyTotalProfit();

        assertEquals(mockMonthlyProfits, result);
        verify(dishRepository, times(1)).findMonthlyTotalProfit(expectedStartDate);
    }

    @Test
    void testGetAnnualTotalProfit() {
        LocalDate expectedStartDate = LocalDate.now().minusYears(1);
        List<TotalProfitDTO> mockAnnualProfits = Arrays.asList(
                new TotalProfitDTO("2024", 60000.0)
        );

        when(dishRepository.findAnnualTotalProfit(expectedStartDate)).thenReturn(mockAnnualProfits);

        List<TotalProfitDTO> result = dishService.getAnnualTotalProfit();

        assertEquals(mockAnnualProfits, result);
        verify(dishRepository, times(1)).findAnnualTotalProfit(expectedStartDate);
    }
}

    

