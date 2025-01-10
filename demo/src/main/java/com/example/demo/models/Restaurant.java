package com.example.demo.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurant_id;
    private String restaurant_password;
    private String restaurant_name;
    private String restaurant_address;
    private String restaurant_email;
    private double restaurant_rating;
    private long restaurant_afm;
    private long restaurant_tel;

    public Restaurant(int restaurant_id, String restaurant_password, String restaurant_name, String restaurant_address,
            String restaurant_email, double restaurant_rating, long restaurant_afm, long restaurant_tel) {
        this.restaurant_id = restaurant_id;
        this.restaurant_password = restaurant_password;
        this.restaurant_name = restaurant_name;
        this.restaurant_address = restaurant_address;
        this.restaurant_email = restaurant_email;
        this.restaurant_rating = restaurant_rating;
        this.restaurant_afm = restaurant_afm;
        this.restaurant_tel = restaurant_tel;
    }

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestaurantDishes> restaurantDishes = new ArrayList<>();
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RTable> tables = new ArrayList<>();
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    // Getters and Setters

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_password() {
        return restaurant_password;
    }

    public void setRestaurant_password(String restaurant_password) {
        this.restaurant_password = restaurant_password;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_address() {
        return restaurant_address;
    }

    public void setRestaurant_address(String restaurant_address) {
        this.restaurant_address = restaurant_address;
    }

    public String getRestaurant_email() {
        return restaurant_email;
    }

    public void setRestaurant_email(String restaurant_email) {
        this.restaurant_email = restaurant_email;
    }

    public double getRestaurant_rating() {
        return restaurant_rating;
    }

    public void setRestaurant_rating(double restaurant_rating) {
        this.restaurant_rating = restaurant_rating;
    }

    public long getRestaurant_afm() {
        return restaurant_afm;
    }

    public void setRestaurant_afm(long restaurant_afm) {
        this.restaurant_afm = restaurant_afm;
    }

    public long getRestaurant_tel() {
        return restaurant_tel;
    }

    public void setRestaurant_tel(long restaurant_tel) {
        this.restaurant_tel = restaurant_tel;
    }

    // Relationships
    public List<RestaurantDishes> getRestaurantDishes() {
        return restaurantDishes;
    }

    public void setRestaurantDishes(List<RestaurantDishes> restaurantDishes) {
        this.restaurantDishes = restaurantDishes;
    }

    public List<RTable> getTables() {
        return tables;
    }

    public void setTables(List<RTable> tables) {
        this.tables = tables;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
