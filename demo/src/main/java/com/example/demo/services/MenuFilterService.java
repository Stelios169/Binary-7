package com.example.demo.services;

import com.example.demo.models.Dish;
import com.example.demo.models.DishIngredients;
import com.example.demo.models.Ingredient;
import com.example.demo.repositories.DishRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MenuFilterService {
    private final DishRepository dishRepository;

    public MenuFilterService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    // Μέθοδος που υπολογίζει το κέρδος κάθε πιάτου, ταξινομεί το μενού και το εμφανίζει ανά κατηγορία
    public Map<String, List<Dish>> viewMenu() {
        List<Dish> dishes = dishRepository.findAll();

        return dishes.stream()
                .peek(dish -> dish.setScore(calculateProfit(dish)))
                .sorted((d1, d2) -> Double.compare(d2.getScore(), d1.getScore()))
                .collect(Collectors.groupingBy(Dish::getDish_category));
    }

    private double calculateProfit(Dish dish) {
        // Υπολογισμός κέρδους ως διαφορά μεταξύ τιμής πιάτου και κόστους συστατικών
        double ingredientCost = dish.getIngredients().stream()
        .mapToDouble(dishIngredient -> {
            // Υπολογισμός κόστους για κάθε συστατικό
            Ingredient ingredient = dishIngredient.getIngredient();
            int ingredientQuantity = dishIngredient.getIngredient_quantity();
            return ingredient.getIngredient_cost() * ingredientQuantity; // Υπολογισμός κόστους συστατικού
        })
        .sum();
        return dish.getDish_price() - ingredientCost;
    }

    // Μέθοδος για φιλτράρισμα με βάση προτιμήσεις πελάτη
    public List<Dish> filterMenu(double budget) {
        return dishRepository.findAll().stream()
                .filter(dish -> dish.getDish_price() <= budget)
                .collect(Collectors.toList());
    }

    private boolean containsCategory(Dish dish, String[] categories) {
        for (String category : categories) {
            if (dish.getDish_category().equalsIgnoreCase(category.trim())) {
                return true;
            }
        }
        return false;
    }

    private boolean containsAllergens(Dish dish, String[] allergies) {
        for (String allergen : allergies) {
            for (DishIngredients dishIngredient : dish.getIngredients()) {
                Ingredient ingredient = dishIngredient.getIngredient();  // Βρίσκουμε το συστατικό
                if (ingredient.getIngredient_name().equalsIgnoreCase(allergen.trim())) {
                    return true;  // Βρέθηκε αλλεργιογόνο
                }
            }
        }
        return false;
    } 
}
