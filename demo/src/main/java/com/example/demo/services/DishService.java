package com.example.demo.services;

import com.example.demo.statistics.dto.DishCostDTO;
import com.example.demo.statistics.dto.FavoriteDishDTO;
import com.example.demo.statistics.dto.DishProfitDTO;
import com.example.demo.statistics.dto.TotalProfitDTO;
import com.example.demo.statistics.dto.SalesDTO;
import com.example.demo.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    // Μέθοδοι για αγαπημένο πιάτο
    public FavoriteDishDTO getFavoriteDishForLastMonth() {
        LocalDate startDate = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        List<FavoriteDishDTO> result = dishRepository.findFavoriteDish(startDate);
        return result.isEmpty() ? null : result.get(0);
        //return dishRepository.findFavoriteDish(startDate);
    }

    public FavoriteDishDTO getFavoriteDishForLastWeek() {
        LocalDate startDate = LocalDate.now().minus(1, ChronoUnit.WEEKS);
        List<FavoriteDishDTO> result = dishRepository.findFavoriteDish(startDate);
        return result.isEmpty() ? null : result.get(0);
        //return dishRepository.findFavoriteDish(startDate);
    }

    // Μέθοδοι για κόστος και κέρδος ανά πιάτο
    public List<DishCostDTO> getDishCost() {
        return dishRepository.findDishCost();
    }

    public List<DishProfitDTO> getDishProfit() {
        return dishRepository.findDishProfit();
    }

    // Μέθοδος για πωλήσεις ανά πιάτο
    public List<SalesDTO> getDishSales() {
        return dishRepository.findDishSales();
    }

    // Μέθοδοι για συνολικό κέρδος
    public List<TotalProfitDTO> getMonthlyTotalProfit() {
        LocalDate startDate = LocalDate.now().withDayOfYear(1);
        return dishRepository.findMonthlyTotalProfit(startDate);
    }

    public List<TotalProfitDTO> getAnnualTotalProfit() {
        LocalDate startDate = LocalDate.now().minusYears(1);
        return dishRepository.findAnnualTotalProfit(startDate);
    }
}
