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
import com.example.demo.models.Ingredient;
import com.example.demo.repositories.IngredientRepository;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

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

    public List<Ingredient> getIngredients(int restaurant_id) {
        return ingredientRepository.findIngredients(restaurant_id);
    }
    
}
