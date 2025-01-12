package com.example.demo.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
        
        @Query("SELECT r FROM Restaurant r WHERE r.restaurant_email = :restaurant_email")
        Optional<Restaurant> findByEmail(@Param("restaurant_email") String restaurant_email);

        /*@Query("SELECT DISTINCT r.restaurant_email FROM Restaurant r " +
                        "JOIN r.restaurantDishes rd " +
                        "JOIN rd.dish d " +
                        "JOIN d.ingredients di " +
                        "WHERE di.id.ingredient_id = :ingredient_id")
        Optional<String> findRestaurantEmailByIngredientId(@Param("ingredient_id") int ingredientId); */

        @Query("SELECT DISTINCT r FROM Restaurant r " +
                "JOIN r.restaurantDishes rd " +
                "JOIN rd.dish d " +
                "JOIN d.ingredients di " +
                "WHERE di.ingredient.id = :ingredient_id " +
                "AND di.ingredient_exp_date <= :expiryThreshold)")
        List<Restaurant> findRestaurantEmailByIngredientId(@Param("ingredient_id") int ingredient_id);


        /*@Query("SELECT DISTINCT r FROM Restaurant r " +
                        "JOIN r.restaurantDishes rd " +
                        "JOIN rd.dish d " +
                        "JOIN d.ingredients di " +
                        "JOIN di.ingredient i " +
                        "WHERE i.ingredient_exp_date <= :expiryThreshold")
        List<Restaurant> findRestaurantsWithExpiringIngredients(@Param("expiryThreshold") LocalDate expiryThreshold);*/

        @Query("SELECT r FROM Restaurant r " +
                "JOIN r.restaurantDishes rd " +
                "JOIN rd.dish d " +
                "JOIN d.ingredients di " +
                "JOIN di.ingredient i " +
                "WHERE i.ingredient_exp_date <= :expiryThreshold")
        List<Restaurant> findRestaurantsWithExpiringIngredients(@Param("expiryThreshold") LocalDate expiryThreshold);

}
