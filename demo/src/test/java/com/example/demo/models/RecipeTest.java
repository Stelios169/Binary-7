package com.example.demo.models;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import com.example.demo.models.Recipe;

public class RecipeTest {
    @Test
        void testRecipeConstructorAndGetters() {
            List<RecipeIngredient> usedIngredients = new ArrayList<>();
            List<RecipeIngredient> missedIngredients = new ArrayList<>();
            Recipe recipe = new Recipe(1, "Test Recipe", "test_image.jpg", 2, 3, usedIngredients, missedIngredients, 100);

            assertEquals(1, recipe.getId());
            assertEquals("Test Recipe", recipe.getTitle());
            assertEquals("test_image.jpg", recipe.getImage());
            assertEquals(2, recipe.getUsedIngredientCount());
            assertEquals(3, recipe.getMissedIngredientCount());
            assertEquals(usedIngredients, recipe.getUsedIngredients());
            assertEquals(missedIngredients, recipe.getMissedIngredients());
            assertEquals(100, recipe.getLikes());
    }

    @Test
    void testPricePerServing() {
        Recipe recipe = new Recipe(1, "Test Recipe", "test_image.jpg", 2, 3, new ArrayList<>(), new ArrayList<>(), 100);
        recipe.pricePerServing = 15.5;

        assertEquals(15.5, recipe.getPricePerServing());
    }
}

