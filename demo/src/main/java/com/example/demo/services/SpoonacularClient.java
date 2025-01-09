package com.example.demo.services;

import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.example.demo.models.Ingredient;
import com.example.demo.models.Recipe;
import java.util.List;

@Component
public class SpoonacularClient {
    private String apiKey;
    private final RestTemplate restTemplate;
 
    public SpoonacularClient(SpoonacularProperties properties, RestTemplate restTemplate) {
        this.apiKey = properties.getKey();
        this.restTemplate = restTemplate;
        System.out.println("Loaded Spoonacular API key: " + apiKey);
    }
 
    public List<Recipe> fetchRecipes(List<Ingredient> ingredients) {
        String ingredientQuery = ingredients.stream()
                .map(Ingredient::getIngredient_name)
                .collect(Collectors.joining(","));
 
        String url = "https://api.spoonacular.com/recipes/findByIngredients?apiKey=f8f8f105241a4e289b1f1dc4d1388116" + ingredientQuery + "&number=10&apiKey=" + apiKey;
 
        ResponseEntity<List<Recipe>> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, null, new org.springframework.core.ParameterizedTypeReference<>() {
        });
 
        return response.getBody();
    }
}
