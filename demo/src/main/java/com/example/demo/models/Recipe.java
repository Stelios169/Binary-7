package com.example.demo.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {
    private int id;
    private String title;
    private String image;
    private int usedIngredientCount;
    private int missedIngredientCount;
    private List<RecipeIngredient> usedIngredients;
    private List<RecipeIngredient> missedIngredients;
    private int likes;
    @JsonProperty("pricePerServing")
    private double pricePerServing;

    public Recipe(int id, String title, String image, int usedIngredientCount, int missedIngredientCount,
                  List<RecipeIngredient> usedIngredients, List<RecipeIngredient> missedIngredients, int likes) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.usedIngredientCount = usedIngredientCount;
        this.missedIngredientCount = missedIngredientCount;
        this.usedIngredients = usedIngredients;
        this.missedIngredients = missedIngredients;
        this.likes = likes;
        //this.pricePerServing = pricePerServing;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getUsedIngredientCount() {
        return usedIngredientCount;
    }

    public int getMissedIngredientCount() {
        return missedIngredientCount;
    }

    public List<RecipeIngredient> getUsedIngredients() {
        return usedIngredients;
    }

    public List<RecipeIngredient> getMissedIngredients() {
        return missedIngredients;
    }

    public int getLikes() {
        return likes;
    }

    public double getPricePerServing() {
        return pricePerServing;
    }

    public void setPricePerServing(double pricePerServing) {
        this.pricePerServing = pricePerServing;
    }
}















    /*private int id;
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
    }  */

