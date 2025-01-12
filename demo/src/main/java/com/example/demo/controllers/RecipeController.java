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
    public String getOptimizedRecipes(@RequestParam int budget, Model model) {
        // Λαμβάνουμε τις βελτιστοποιημένες συνταγές
        List<Recipe> recipes = recipeOptimizerService.findOptimizedRecipes(LocalDate.now().plusDays(7), budget);

        // Προσθέτουμε τις συνταγές στο μοντέλο
        model.addAttribute("recipes", recipes);

        // Επιστρέφουμε το όνομα του HTML template (θα το βρει στον φάκελο templates)
        return "ingredients";  // Το όνομα του αρχείου HTML χωρίς την κατάληξη .html
    }
}