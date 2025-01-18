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
 
import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeOptimizerService;
import java.util.List;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
 
@Controller
@RequestMapping("/login")
public class RecipeController {
 
    private final RecipeOptimizerService recipeOptimizerService;
 
    public RecipeController(RecipeOptimizerService recipeOptimizerService) {
        this.recipeOptimizerService = recipeOptimizerService;
    }
    @Autowired
    private RestTemplate restTemplate;
 
    @GetMapping("/ingredients")
    public String getIngredientsPage(Model model) {
        // Επιστρέφει την κενή φόρμα για να εισαγάγει ο χρήστης τον προϋπολογισμό
        model.addAttribute("budget", 0); // Ή οποιαδήποτε προεπιλεγμένη τιμή
        return "ingredients"; // Επιστρέφει το template
    }
 
    @GetMapping("/ingredients/submit")
    public String getOptimizedRecipes(@RequestParam int budget, Model model) {
 
        List<Recipe> recipes = recipeOptimizerService.findOptimizedRecipes(LocalDate.now().plusDays(7), budget);
 
        // Προσθέτουμε τις συνταγές στο μοντέλο
        model.addAttribute("recipes", recipes);
        model.addAttribute("budget", budget); // Επιστρέφουμε τον προϋπολογισμό για να εμφανίζεται στη σελίδα
 
        return "ingredients"; // Επιστρέφουμε το ίδιο template
    }
}
 