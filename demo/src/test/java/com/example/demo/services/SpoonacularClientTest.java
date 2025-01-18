package com.example.demo.services;

 /*import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
 import com.example.demo.models.Ingredient;
 import com.example.demo.models.Recipe;
 import com.fasterxml.jackson.core.type.TypeReference;
 import com.fasterxml.jackson.databind.ObjectMapper;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
 import org.mockito.InjectMocks;
 import org.mockito.Mock;
 import org.mockito.MockitoAnnotations;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.client.RestTemplate;
 import java.util.Collections;
 import java.util.List;
import org.springframework.http.HttpMethod;

public class SpoonacularClientTest {
 
    @Mock
    private RestTemplate restTemplate;
 
    @Mock
    private ObjectMapper objectMapper;
 
    
    private SpoonacularClient spoonacularClient;
    
    @Mock
    private SpoonacularProperties properties;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        //properties = mock(SpoonacularProperties.class); // Δημιουργία mock για το SpoonacularProperties
        when(properties.getKey()).thenReturn("a2c8a3f573b44ed19de40d427fddf190"); // Ορισμός του API key
        spoonacularClient = new SpoonacularClient(properties, restTemplate, objectMapper);
    }
 
    @Test
    void testFetchRecipes_success() throws Exception {
        // Mock δεδομένα
        Ingredient ingredient1 = new Ingredient("Tomato", 10.0, 1, 2.5, "kg", null);
        Ingredient ingredient2 = new Ingredient("Cheese", 5.0, 2, 4.5, "kg", null);
        List<Ingredient> ingredients = List.of(ingredient1, ingredient2);
 
        String jsonResponse = "[{\"id\":1,\"title\":\"Recipe 1\",\"image\":\"image1\",\"usedIngredientCount\":2,\"missedIngredientCount\":1,\"usedIngredients\":[],\"missedIngredients\":[],\"likes\":100}]";
 
        // Mock το RestTemplate και ObjectMapper
        when(restTemplate.exchange(
            anyString(),
            eq(HttpMethod.GET),
            eq(null),
            eq(String.class)
        )).thenReturn(ResponseEntity.ok(jsonResponse));
 
        List<Recipe> mockRecipes = List.of(new Recipe(1, "Recipe 1", "image1", 2, 1, Collections.emptyList(), Collections.emptyList(), 100));
        when(objectMapper.readValue(anyString(), any(TypeReference.class))).thenReturn(mockRecipes);
 
        // Κλήση της μεθόδου
        List<Recipe> recipes = spoonacularClient.fetchRecipes(ingredients);
 
        // Επαληθεύσεις
        assertNotNull(recipes);
        assertEquals(1, recipes.size());
        assertEquals("Recipe 1", recipes.get(0).getTitle());
        assertEquals(100, recipes.get(0).getLikes());
 
        // Επαλήθευση της κλήσης στο RestTemplate
        verify(restTemplate, times(1)).exchange(anyString(), eq(HttpMethod.GET), eq(null), eq(String.class));
    }
 
    @Test
    void testFetchRecipes_failure() throws Exception {
        // Mock δεδομένα
        Ingredient ingredient1 = new Ingredient("Tomato", 10.0, 1, 2.5, "kg", null);
        List<Ingredient> ingredients = List.of(ingredient1);
 
        // Mock το RestTemplate να πετάει exception
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), eq(null), eq(String.class)))
            .thenThrow(new RuntimeException("API Error"));
 
        // Κλήση της μεθόδου
        List<Recipe> recipes = spoonacularClient.fetchRecipes(ingredients);
 
        // Επαλήθευση ότι επιστρέφεται κενή λίστα
        assertNotNull(recipes);
        assertTrue(recipes.isEmpty());
 
        // Επαλήθευση της κλήσης στο RestTemplate
        verify(restTemplate, times(1)).exchange(anyString(), eq(HttpMethod.GET), eq(null), eq(String.class));
    }
 
    @Test
    void testMissingApiKey() {
        // Δημιουργία properties χωρίς API key
        SpoonacularProperties emptyProperties = new SpoonacularProperties();
        emptyProperties.setKey("");
 
        // Αναμένεται εξαίρεση IllegalStateException
        assertThrows(IllegalStateException.class, () -> new SpoonacularClient(emptyProperties, restTemplate, objectMapper));
    }
}*/


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.example.demo.models.Ingredient;
import com.example.demo.services.SpoonacularClient;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import com.example.demo.models.Recipe;
import java.util.Collections;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;

public class SpoonacularClientTest {

    @Mock
    private ObjectMapper objectMapper;
    
    /*@Mock
    private SpoonacularProperties properties;*/
 

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private SpoonacularClient spoonacularClient;

    @BeforeEach
    public void setup() {              
    MockitoAnnotations.openMocks(this); 
    SpoonacularProperties properties = new SpoonacularProperties("dummy-api-key");   
        spoonacularClient = new SpoonacularClient(properties, restTemplate, objectMapper, "dummy-api-key");
    }

    //spoonacularClient = new SpoonacularClient(new SpoonacularProperties("dummy-api-key"), restTemplate, objectMapper); }

    /*public SpoonacularClientTest() {
        // Χρησιμοποιούμε το mock RestTemplate για να δημιουργήσουμε την SpoonacularClient
        spoonacularClient = new SpoonacularClient(
            new SpoonacularProperties("dummy-api-key"), restTemplate, new ObjectMapper()
        );
    }*/


    @Test
    void testIngredientQueryConstruction() {
        // Δημιουργούμε mock συστατικά
        Ingredient ingredient1 = new Ingredient("Tomato", 10.0, 1, 2.5, "kg", null);
        Ingredient ingredient2 = new Ingredient("Cheese", 5.0, 2, 4.5, "kg", null);
        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient2);

        // Καλούμε την μέθοδο fetchRecipes
        String ingredientQuery = spoonacularClient.buildIngredientQuery(ingredients);

        // Ελέγχουμε αν το query κατασκευάστηκε σωστά
        String expectedQuery = "Tomato,Cheese";
        assertEquals(expectedQuery, ingredientQuery, "The ingredient query is not correctly constructed!");
    }

    @Test
    void testFetchRecipes() throws Exception {
        // Δημιουργούμε mock συστατικά
        Ingredient ingredient1 = new Ingredient("Tomato", 10.0, 1, 2.5, "kg", null);
        Ingredient ingredient2 = new Ingredient("Cheese", 5.0, 2, 4.5, "kg", null);
        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient2);

        // Mock για το RestTemplate response
        String jsonResponse = "[{\"id\": 1, \"title\": \"Tomato Cheese Pizza\"}]";
        System.out.println("Mock JSON Response: " + jsonResponse);
        ResponseEntity<String> mockResponse = ResponseEntity.ok(jsonResponse);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), isNull(), eq(String.class)))
            .thenReturn(mockResponse);
        
        List<Recipe> mockRecipes = List.of(new Recipe(1, "Tomato Cheese Pizza", "image1", 2, 1, Collections.emptyList(), Collections.emptyList(), 100));
        when(objectMapper.readValue(anyString(), any(TypeReference.class))).thenReturn(mockRecipes);
            
        


        // Καλούμε τη μέθοδο fetchRecipes
        List<Recipe> recipes = spoonacularClient.fetchRecipes(ingredients);

// Επαλήθευση ότι η λίστα περιέχει τη συνταγή
assertNotNull(recipes);
assertEquals(1, recipes.size());
assertEquals("Tomato Cheese Pizza", recipes.get(0).getTitle());
assertEquals(100, recipes.get(0).getLikes());

// Επαλήθευση ότι το RestTemplate χρησιμοποιείται σωστά
verify(restTemplate, times(1)).exchange(anyString(), eq(HttpMethod.GET), eq(null), eq(String.class));

        // Ελέγχουμε αν το αποτέλεσμα είναι σωστό
        assertNotNull(recipes, "The recipes list should not be null!");
        assertEquals(1, recipes.size(), "The recipes list size should be 1!");
        assertEquals("Tomato Cheese Pizza", recipes.get(0).getTitle(), "The recipe title should be 'Tomato Cheese Pizza'");
    }
}
