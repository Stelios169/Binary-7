// package com.example.demo.services;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.ArgumentMatchers.anyList;
// import static org.mockito.Mockito.when;
// import java.time.LocalDate;
// import java.util.ArrayList;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import com.example.demo.models.Ingredient;
// import com.example.demo.models.Recipe;
// import com.example.demo.repositories.IngredientRepository;
// import java.util.List;
// import java.util.Collections;

// public class RecipeOptimizerTest {

// @Mock
// private IngredientRepository ingredientRepository;

// @Mock
// private SpoonacularClient spoonacularClient;

// @InjectMocks
// private RecipeOptimizerService recipeOptimizerService;

// @BeforeEach
// void setUp() {
// MockitoAnnotations.openMocks(this);
// recipeOptimizerService = new RecipeOptimizerService(ingredientRepository,
// spoonacularClient);
// }

// @Test
// void testFindOptimizedRecipes() {
// // Mock data
// LocalDate thresholdDate = LocalDate.now();
// Ingredient ingredient = new Ingredient("Tomato", 10, LocalDate.now());
// Recipe recipe = new Recipe("Recipe 1", 10.0, new ArrayList<>(), new
// ArrayList<>());

// when(ingredientRepository.findByIngredientExpDateBefore(thresholdDate))
// .thenReturn(List.of(ingredient));
// when(spoonacularClient.fetchRecipes(anyList()))
// .thenReturn(List.of(recipe));

// // Call the method
// List<Recipe> optimizedRecipes =
// recipeOptimizerService.findOptimizedRecipes(thresholdDate, 50);

// // Assertions
// assertNotNull(optimizedRecipes);
// assertEquals(1, optimizedRecipes.size());
// assertEquals("Recipe 1", optimizedRecipes.get(0).getTitle());
// }

// @Test
// void testFindOptimizedRecipes_noIngredients() {
// // Mock data
// LocalDate thresholdDate = LocalDate.now();
// when(ingredientRepository.findByIngredientExpDateBefore(thresholdDate))
// .thenReturn(Collections.emptyList());

// // Call the method
// List<Recipe> optimizedRecipes =
// recipeOptimizerService.findOptimizedRecipes(thresholdDate, 50);

// // Assertions
// assertNotNull(optimizedRecipes);
// assertTrue(optimizedRecipes.isEmpty());
// }
// }
