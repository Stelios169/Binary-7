package com.example.demo.controllers;

import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeOptimizerService;
import java.util.List;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.RequestParam;
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