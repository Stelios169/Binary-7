package com.example.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.models.Dish;
import com.example.demo.models.DishProfit;
import java.util.Optional;
 
public interface DishRepository extends JpaRepository<Dish, Integer> {
    @Query("""
        SELECT new com.example.dto.DishProfit(d.id, d.name, d.restaurant.id, d.price, 
            (SUM(i.cost * di.quantity)), (d.price - SUM(i.cost * di.quantity)), dc.name)
        FROM Dish d
        JOIN d.ingredients di
        JOIN di.ingredient i
        JOIN d.category dc
        GROUP BY d.id, d.name, d.restaurant.id, d.price, dc.name
    """)
    List<DishProfit> calculateAndSortDishProfit(); 
        @Query("SELECT r.restaurant_email FROM Restaurant r " +
       "JOIN r.dishes d " +
       "JOIN d.ingredients di " +
       "WHERE di.ingredient.ingredient_id = :ingredient_id")
    Optional<String> findRestaurantEmailByIngredientId(@Param("ingredient_id") int ingredientId);
}
