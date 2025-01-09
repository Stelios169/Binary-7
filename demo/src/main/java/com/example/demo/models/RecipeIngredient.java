package com.example.demo.models;

public class RecipeIngredient {
    private String name;
    private int neededQuantity;
 
    public RecipeIngredient(String name, int neededQuantity) {
        this.name = name;
        this.neededQuantity = neededQuantity;
    }
 
    public String getName() {
        return name;
    }
 
    public int getNeededQuantity() {
        return neededQuantity;
    }
}
