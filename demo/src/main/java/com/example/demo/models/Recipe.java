package com.example.demo.models;


import java.util.List;
 
public class Recipe {
    private String name;
    private List<RecipeIngredient> ingredients;
    private int preparationTime;
    private double pricePerServing;
 
    public Recipe(String name, List<RecipeIngredient> ingredients, int preparationTime, double pricePerServing) {
        this.name = name;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.pricePerServing = pricePerServing;
    }
 
    public String getName() {
        return name;
    }
 
    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }
 
    public int getPreparationTime() {
        return preparationTime;
    }
 
    public double getPricePerServing() {
        return pricePerServing;
    }
   
}
