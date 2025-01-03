package com.example.demo.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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
    public Restaurant(int restaurant_id, String restaurant_password, String restaurant_name, String restaurant_address, String restaurant_email, double restaurant_rating, long restaurant_afm, long restaurant_tel) {
        this.restaurant_id = restaurant_id;
        this.restaurant_password = restaurant_password;
        this.restaurant_name = restaurant_name;
        this.restaurant_address = restaurant_address;
        this.restaurant_email = restaurant_email;
        this.restaurant_rating = restaurant_rating;
        this.restaurant_afm = restaurant_afm;
        this.restaurant_tel = restaurant_tel;   
    }
    @ManyToMany
    @JoinTable(
        name = "RestaurantDishes", // Ονόμα της join table
        joinColumns = @JoinColumn(name = "restaurant_id"),
        inverseJoinColumns = @JoinColumn(name = "dish_id")
    )  
    private List<Dish> dishes = new ArrayList<>(); 
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RTable> tables = new ArrayList<>();
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();   
}
