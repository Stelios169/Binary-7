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
 
import com.example.demo.models.DId;
import com.example.demo.models.Dish;
import com.example.demo.models.DishIngredients;
import com.example.demo.models.Ingredient;
import com.example.demo.repositories.DishRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
public class MenuFilterServiceTest {
 
    @Mock
    private DishRepository dishRepository;
 
    private MenuFilterService menuFilterService;
 
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        menuFilterService = new MenuFilterService(dishRepository);
    }
 
    @Test
    public void testViewMenu() {
        Dish dish1 = createDish("Pizza", 10.0, 5.0, "Italian", createIngredients(2.0, 1));
        Dish dish2 = createDish("Burger", 8.0, 3.5, "Fast Food", createIngredients(1.5, 2));
 
        when(dishRepository.findAll()).thenReturn(Arrays.asList(dish1, dish2));
 
        Map<String, List<Dish>> result = menuFilterService.viewMenu();
 
        assertEquals(2, result.size());
        assertEquals(1, result.get("Italian").size());
        assertEquals(1, result.get("Fast Food").size());
        verify(dishRepository, times(1)).findAll();
    }
 
    @Test
    public void testFilterMenu() {
        Dish dish1 = createDish("Salad", 6.0, 2.5, "Healthy", createIngredients(1.0, 1));
        Dish dish2 = createDish("Steak", 20.0, 10.0, "Gourmet", createIngredients(5.0, 2));
 
        when(dishRepository.findAll()).thenReturn(Arrays.asList(dish1, dish2));
 
        List<Dish> result = menuFilterService.filterMenu(10.0);
 
        assertEquals(1, result.size());
        assertEquals("Salad", result.get(0).getDish_name());
        verify(dishRepository, times(1)).findAll();
    }
 
    @Test
    public void testFilterByCategory() {
        Dish dish1 = createDish("Pasta", 12.0, 6.0, "Italian", createIngredients(2.0, 1));
        Dish dish2 = createDish("Sushi", 15.0, 7.5, "Japanese", createIngredients(3.0, 2));
 
        when(dishRepository.findAll()).thenReturn(Arrays.asList(dish1, dish2));
 
        List<Dish> result = menuFilterService.filterByCategory(new String[]{"Italian"});
 
        assertEquals(1, result.size());
        assertEquals("Pasta", result.get(0).getDish_name());
        verify(dishRepository, times(1)).findAll();
    }
 
    @Test
    public void testFilterByAllergens() {
        Dish dish1 = createDish("Pizza", 10.0, 5.0, "Italian", createIngredients(2.0, 1, "Cheese"));
        Dish dish2 = createDish("Salad", 6.0, 2.5, "Healthy", createIngredients(1.0, 1, "Lettuce"));
 
        when(dishRepository.findAll()).thenReturn(Arrays.asList(dish1, dish2));
 
        List<Dish> result = menuFilterService.filterByAllergens(new String[]{"Cheese"});
 
        assertEquals(1, result.size());
        assertEquals("Salad", result.get(0).getDish_name());
        verify(dishRepository, times(1)).findAll();
    }
 
    private Dish createDish(String name, double price, double cost, String category, List<DishIngredients> ingredients) {
        Dish dish = new Dish(1, name, category, price, "pasta.jpg", "Pasta food", true);
        dish.setDish_name(name);
        dish.setDish_price(price);
        dish.setDish_category(category);
        dish.setIngredients(ingredients);
        return dish;
    }
 
    private List<DishIngredients> createIngredients(double cost, int quantity, String... names) {
        return Arrays.stream(names).map(name -> {
            Ingredient ingredient = new Ingredient(1, name, cost, "kg", 34, LocalDate.now());
            ingredient.setIngredient_name(name);
            ingredient.setIngredient_cost(cost);
            Dish dish = new Dish(1, "Pasta", "Main", 13, "pasta.jpg", "Pasta food", true);
            DId id = new DId();
            id.setIngredient_id(ingredient.getIngredient_id()); // Assuming ingredient has getId() method
            id.setDish_id(dish.getDish_id()); // Assuming dish has getId() method
            DishIngredients dishIngredients = new DishIngredients(id, ingredient, dish, quantity);
            dishIngredients.setIngredient(ingredient);
            dishIngredients.setIngredient_quantity(quantity);
            return dishIngredients;
        }).collect(Collectors.toList());
    }
    

}
