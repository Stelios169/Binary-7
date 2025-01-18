package com.example.demo.controllers;

import com.example.demo.services.MenuFilterService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Map;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(MenuFilterController.class)
public class MenuFilterControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
