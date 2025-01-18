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

import com.example.demo.services.MenuFilterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(MenuFilterController.class)
public class MenuFilterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private MenuFilterService menuFilterService;

    @Test
    public void testFilterMenuWithBudget() throws Exception {
        // Mock the service method for filtering menu by budget
        when(menuFilterService.filterMenu(10.0)).thenReturn(List.of());

        // Perform the GET request to /menu/menu with budget parameter and check the result
        mockMvc.perform(MockMvcRequestBuilders.get("/menu/menu")
                .param("budget", "10.0"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("menu"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("filteredDishes"));
    }

    @Test
    public void testFilterMenuWithCategories() throws Exception {
        // Mock the service method for filtering menu by categories
        when(menuFilterService.filterMenu(10.0)).thenReturn(List.of());

        // Perform the GET request with categories and check the result
        mockMvc.perform(MockMvcRequestBuilders.get("/menu/menu")
                .param("budget", "10.0")
                .param("categories", "vegetarian", "gluten-free"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("menu"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("filteredDishes"));
    }

    @Test
    public void testFilterMenuWithAllergens() throws Exception {
        // Mock the service method for filtering menu by allergens
        when(menuFilterService.filterMenu(10.0)).thenReturn(List.of());

        // Perform the GET request with allergens and check the result
        mockMvc.perform(MockMvcRequestBuilders.get("/menu/menu")
                .param("budget", "10.0")
                .param("allergies", "peanut", "shellfish"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("menu"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("filteredDishes"));
    }
}
