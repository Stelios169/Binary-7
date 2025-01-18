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

/*package com.example.demo.services;
 
import java.util.stream.Collectors;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.example.demo.models.Ingredient;
import com.example.demo.models.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URLEncoder;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import com.fasterxml.jackson.core.type.TypeReference;
 
@Component
public class SpoonacularClient {
    private final String apiKey;
    private final RestTemplate restTemplate;
    ObjectMapper objectMapper = new ObjectMapper();
 
    public SpoonacularClient(SpoonacularProperties properties, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.apiKey = properties.getKey();
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        if (this.apiKey == null || this.apiKey.isEmpty()) {        
            throw new IllegalStateException("Spoonacular API key is missing!"); }
    }
 
    public List<Recipe> fetchRecipes(List<Ingredient> ingredients) {
       System.out.println("Entering fetchRecipes method...");
        String ingredientQuery = ingredients.stream()
                .map(Ingredient::getIngredient_name)
                .map(name -> URLEncoder.encode(name, StandardCharsets.UTF_8))
                .collect(Collectors.joining(","));
 
        //String url = "https://api.spoonacular.com/recipes/findByIngredients?ingredients=" + ingredientQuery + "&number=10&apiKey=" + apiKey;
        String url = String.format(
            "https://api.spoonacular.com/recipes/findByIngredients?ingredients=%s&number=5&apiKey=%s",
            ingredientQuery,
            apiKey
        );
        System.out.println("Request URL: " + url);  // Έλεγχος της URL
   
        //ResponseEntity<List<Recipe>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Recipe>>() {});
       /*ResponseEntity<List<Recipe>> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, null, new org.springframework.core.ParameterizedTypeReference<>() {
        }); */
        // Έλεγχος του κωδικού κατάστασης της απόκρισης
        /*if (response.getStatusCode().is2xxSuccessful()) {
        // Αν η απόκριση είναι επιτυχής, εκτύπωσε το σώμα της απόκρισης
        System.out.println("Response: " + response.getBody());
        } else {
        // Αν υπάρχει κάποιο σφάλμα, εκτύπωσε τον κωδικό κατάστασης
        System.out.println("Error response: " + response.getStatusCode());
        }
 
        return response.getBody();*/
       /* try {
            // Κάντε την κλήση στο API
            ResponseEntity<String> response = restTemplate.exchange(
                url,
                //org.springframework.http.HttpMethod.GET,
                HttpMethod.GET,
                null,
                String.class
            );
 
            // Διαχειριστείτε την απόκριση JSON
            String jsonResponse = response.getBody();
 
            // Μετατροπή JSON σε αντικείμενα Recipe
            return objectMapper.readValue(jsonResponse, new TypeReference<List<Recipe>>() {});
 
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); // Επιστρέψτε μια άδεια λίστα σε περίπτωση σφάλματος
        }
    }
    }*/
    
    package com.example.demo.services;

    import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Component;
    import org.springframework.web.client.RestTemplate;
    import com.example.demo.models.Ingredient;
    import com.example.demo.models.Recipe;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import java.net.URLEncoder;
    import java.util.List;
    import java.nio.charset.StandardCharsets;
    import java.util.Collections;
    import com.fasterxml.jackson.core.type.TypeReference;
    import org.springframework.beans.factory.annotation.Value;
    
    @Component
    public class SpoonacularClient {
        private final String apiKey;
        private final RestTemplate restTemplate;
        ObjectMapper objectMapper = new ObjectMapper();
    
        @Autowired
        public SpoonacularClient(SpoonacularProperties properties, RestTemplate restTemplate, ObjectMapper objectMapper, @Value("${spoonacular.api.key}") String apiKey) {
            this.restTemplate = restTemplate;
            this.objectMapper = objectMapper;
            if (apiKey == null || apiKey.isEmpty()) {        
                throw new IllegalStateException("Spoonacular API key is missing!"); }
            this.apiKey = apiKey;
        }
    
        // Δημιουργία του query για τα συστατικά
        public String buildIngredientQuery(List<Ingredient> ingredients) {
            return ingredients.stream()
                    .map(Ingredient::getIngredient_name)
                    .map(name -> URLEncoder.encode(name, StandardCharsets.UTF_8))
                    .collect(Collectors.joining(","));
        }
    
        public List<Recipe> fetchRecipes(List<Ingredient> ingredients) {
            System.out.println("Entering fetchRecipes method...");
            
            // Χρησιμοποιούμε τη μέθοδο buildIngredientQuery για να δημιουργήσουμε το query
            String ingredientQuery = buildIngredientQuery(ingredients);
    
            // Δημιουργία της URL με το query
            String url = String.format(
                "https://api.spoonacular.com/recipes/findByIngredients?ingredients=%s&number=5&apiKey=%s",
                ingredientQuery,
                apiKey
            );
            System.out.println("Request URL: " + url);  // Έλεγχος της URL
            
            String jsonResponse = null; // Declare jsonResponse outside the try block
            try {
                // Κάντε την κλήση στο API
                ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    String.class
                );
    
                // Διαχειριστείτε την απόκριση JSON
                jsonResponse = response.getBody();
                System.out.println("Response Body: " + jsonResponse); 
    
                // Μετατροπή JSON σε αντικείμενα Recipe
                return objectMapper.readValue(jsonResponse, new TypeReference<List<Recipe>>() {});
    
            } catch (Exception e) {
                e.printStackTrace();
                return Collections.emptyList(); // Επιστρέψτε μια άδεια λίστα σε περίπτωση σφάλματος
            }
            /*try {
               List<Recipe> recipes = objectMapper.readValue(jsonResponse, new TypeReference<List<Recipe>>() {});
                return recipes;
            } catch (Exception e) {
                e.printStackTrace();  // Εκτύπωση του σφάλματος για αποσφαλμάτωση
                return Collections.emptyList();
            }*/
            
        } 
    }
    
 
 

