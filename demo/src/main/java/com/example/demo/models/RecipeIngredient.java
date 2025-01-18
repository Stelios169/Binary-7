/*
 * Copyright 2024-2025 Binary 7
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
