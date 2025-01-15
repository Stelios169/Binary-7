package com.example.demo.models;


import java.util.List;
 
public class Recipe {
    private int id;
    private String imageUrl;
    private String name;
    private List<RecipeIngredient> ingredients;
    private int preparationTime;
    private double pricePerServing;
 
    public Recipe(String name, List<RecipeIngredient> ingredients, int preparationTime, double pricePerServing, int id, String imageUrl) {
        this.name = name;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.pricePerServing = pricePerServing;
        this.id = id;
        this.imageUrl = imageUrl;
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
    public String getImageUrl() {
        return imageUrl;
    }
    public int getId() {
        return id;
    }  
}
