package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.example.demo.models.Ingredient;
import com.example.demo.models.Recipe;
import com.example.demo.repositories.IngredientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;


public class SpoonacularClientTest {
    @Mock
    private RestTemplate restTemplate;
    
    @Mock
    private SpoonacularProperties properties;
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @InjectMocks
    private SpoonacularClient spoonacularClient;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(properties.getKey()).thenReturn("test_api_key");
        spoonacularClient = new SpoonacularClient(properties, restTemplate, objectMapper);
    }
    @Test
    void testFetchRecipes_success() throws Exception {
        // Mock data
        Ingredient ingredient = new Ingredient("Tomato", 10, LocalDate.now());
        List<Ingredient> ingredients = List.of(ingredient);
        String mockResponse = "[ { \"title\": \"Recipe 1\", \"pricePerServing\": 10.0, \"usedIngredients\": [], \"missedIngredients\": [] } ]";
    
        // Mock REST API response
        when(restTemplate.exchange(
                anyString(),
                eq(org.springframework.http.HttpMethod.GET),
                isNull(),
                eq(String.class)
        )).thenReturn(ResponseEntity.ok(mockResponse));
    
        // Call the method
        List<Recipe> recipes = spoonacularClient.fetchRecipes(ingredients);
    
        // Assertions
        assertNotNull(recipes);
        assertEquals(1, recipes.size());
        assertEquals("Recipe 1", recipes.get(0).getTitle());
    }
    
    @Test
    void testFetchRecipes_failure() {
        // Mock data
        Ingredient ingredient = new Ingredient("Tomato", 10, LocalDate.now());
        List<Ingredient> ingredients = List.of(ingredient);
    
        // Mock REST API response
        when(restTemplate.exchange(
                anyString(),
                eq(org.springframework.http.HttpMethod.GET),
                isNull(),
                eq(String.class)
        )).thenThrow(new RuntimeException("API Error"));
    
        // Call the method
        List<Recipe> recipes = spoonacularClient.fetchRecipes(ingredients);
    
        // Assertions
        assertNotNull(recipes);
        assertTrue(recipes.isEmpty());
    }
}
