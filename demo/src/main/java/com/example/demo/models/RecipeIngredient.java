package com.example.demo.models;

public class RecipeIngredient {
    private int id;
    private double amount;
    private String unit;
    private String name;
    private String original;
    private String image;
    
    public RecipeIngredient(int id, double amount, String unit, String name, String original, String image) {
            this.id = id;
            this.amount = amount;
            this.unit = unit;
            this.name = name;
            this.original = original;
            this.image = image;
        }
    
        public int getId() {
            return id;
        }
    
        public double getAmount() {
            return amount;
        }
    
        public String getUnit() {
            return unit;
        }
    
        public String getName() {
            return name;
        }
    
        public String getOriginal() {
            return original;
        }
    
        public String getImage() {
            return image;
        }
    }












    /*private String name;
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
    }*/
