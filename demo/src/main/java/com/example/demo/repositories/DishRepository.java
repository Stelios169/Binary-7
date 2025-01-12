package com.example.demo.repositories;

import com.example.demo.statistics.dto.TotalProfitDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.models.Dish;
import com.example.demo.statistics.dto.DishCostDTO;
import com.example.demo.statistics.dto.DishProfitDTO;
import com.example.demo.statistics.dto.FavoriteDishDTO;
import com.example.demo.statistics.dto.SalesDTO;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface DishRepository extends JpaRepository<Dish, Integer> {
<<<<<<< Updated upstream
    // Query για το αγαπημένο πιάτο εβδομαδιαιώς
    @Query("SELECT new com.example.demo.statistics.dto.FavoriteDishDTO(d.dish_name, SUM(od.orderPerDish_quantity)) " +
           "FROM OrderPerDish od " +
           "JOIN Orders o ON od.order.order_id = o.order_id " +
           "JOIN Dish d ON od.dish.dish_id = d.dish_id " +
           "WHERE o.order_datetime >= :startDate " +
           "GROUP BY d.dish_name " + 
           "ORDER BY SUM(od.orderPerDish_quantity) DESC")
    List<FavoriteDishDTO> findFavoriteDish(@Param("startDate")LocalDate startDate);
 
    // Query για το κόστος ανά πιάτο
    @Query("SELECT new com.example.demo.statistics.dto.DishCostDTO(d.dish_name, SUM(di.ingredient_quantity * i.ingredient_cost)) " +
           "FROM Dish d " +
           "JOIN DishIngredients di ON d.dish_id = di.dish.dish_id " +
           "JOIN Ingredient i ON di.ingredient.ingredient_id = i.ingredient_id " +
           "GROUP BY d.dish_name")
    List<DishCostDTO> findDishCost();
 
    // Query για το κέρδος ανά πιάτο
    @Query("SELECT new com.example.demo.statistics.dto.DishProfitDTO(d.dish_name, SUM(od.orderPerDish_quantity * (d.dish_price - di.ingredient_quantity * i.ingredient_cost))) " +
           "FROM OrderPerDish od " +
           "JOIN Orders o ON od.order.order_id = o.order_id " +
           "JOIN Dish d ON od.dish.dish_id = d.dish_id " +
           "JOIN DishIngredients di ON d.dish_id = di.dish.dish_id " +
           "JOIN Ingredient i ON di.ingredient.ingredient_id = i.ingredient_id " +
           "GROUP BY d.dish_name")
    List<DishProfitDTO> findDishProfit();
 
    // Query για πωλήσεις ανά πιάτο
    @Query("SELECT new com.example.demo.statistics.dto.SalesDTO(d.dish_name, SUM(od.orderPerDish_quantity)) " +
           "FROM OrderPerDish od " +
           "JOIN Orders o ON od.order.order_id = o.order_id " +
           "JOIN Dish d ON od.dish.dish_id = d.dish_id " +
           "GROUP BY d.dish_name")
    List<SalesDTO> findDishSales();
 
    // Query για το συνολικό κέρδος μηνιαίως
    @Query("SELECT new com.example.demo.statistics.dto.TotalProfitDTO('Monthly', SUM(od.orderPerDish_quantity * (d.dish_price - di.ingredient_quantity * i.ingredient_cost))) " +
           "FROM OrderPerDish od " +
           "JOIN Orders o ON od.order.order_id = o.order_id " +
           "JOIN Dish d ON od.dish.dish_id = d.dish_id " +
           "JOIN DishIngredients di ON d.dish_id = di.dish.dish_id " +
           "JOIN Ingredient i ON di.ingredient.ingredient_id = i.ingredient_id " +
           "WHERE o.order_datetime >= :startDate")
    List<TotalProfitDTO> findMonthlyTotalProfit(@Param("startDate") LocalDate startDate);
 
    // Query για το συνολικό κέρδος ετησίως
    @Query("SELECT new com.example.demo.statistics.dto.TotalProfitDTO('Annual', SUM(od.orderPerDish_quantity * (d.dish_price - di.ingredient_quantity * i.ingredient_cost))) " +
           "FROM OrderPerDish od " +
           "JOIN Orders o ON od.order.order_id = o.order_id " +
           "JOIN Dish d ON od.dish.dish_id = d.dish_id " +
           "JOIN DishIngredients di ON d.dish_id = di.dish.dish_id " +
           "JOIN Ingredient i ON di.ingredient.ingredient_id = i.ingredient_id " +
           "WHERE o.order_datetime >= :startDate")
    List<TotalProfitDTO> findAnnualTotalProfit(@Param("startDate") LocalDate startDate);

    @Query("SELECT d FROM Dish d WHERE d.dish_id = :id")
    Optional<Dish> findById(@Param("id") Integer id);
=======
       // Query για το αγαπημένο πιάτο εβδομαδιαιώς
       @Query("SELECT new com.example.demo.statistics.dto.FavoriteDishDTO(d.dish_name, SUM(od.orderPerDish_quantity)) "
                     +
                     "FROM OrderPerDish od " +
                     "JOIN Orders o ON od.order.order_id = o.order_id " +
                     "JOIN Dish d ON od.dish.dish_id = d.dish_id " +
                     "WHERE CAST(o.order_datetime AS date) >= :startDate " +
                     "GROUP BY d.dish_name " +
                     "ORDER BY SUM(od.orderPerDish_quantity) DESC")
       List<FavoriteDishDTO> findFavoriteDish(@Param("startDate") LocalDate startDate);

       // Query για το κόστος ανά πιάτο
       @Query("SELECT new com.example.demo.statistics.dto.DishCostDTO(d.dish_name, SUM(di.ingredient_quantity * i.ingredient_cost)) "
                     +
                     "FROM Dish d " +
                     "JOIN DishIngredients di ON d.dish_id = di.dish.dish_id " +
                     "JOIN Ingredient i ON di.ingredient.ingredient_id = i.ingredient_id " +
                     "GROUP BY d.dish_name")
       List<DishCostDTO> findDishCost();

       // Query για το κέρδος ανά πιάτο
       @Query("SELECT new com.example.demo.statistics.dto.DishProfitDTO(d.dish_name, SUM(od.orderPerDish_quantity * (d.dish_price - di.ingredient_quantity * i.ingredient_cost))) "
                     +
                     "FROM OrderPerDish od " +
                     "JOIN Orders o ON od.order.order_id = o.order_id " +
                     "JOIN Dish d ON od.dish.dish_id = d.dish_id " +
                     "JOIN DishIngredients di ON d.dish_id = di.dish.dish_id " +
                     "JOIN Ingredient i ON di.ingredient.ingredient_id = i.ingredient_id " +
                     "GROUP BY d.dish_name")
       List<DishProfitDTO> findDishProfit();

       // Query για πωλήσεις ανά πιάτο
       @Query("SELECT new com.example.demo.statistics.dto.SalesDTO(d.dish_name, SUM(od.orderPerDish_quantity)) " +
                     "FROM OrderPerDish od " +
                     "JOIN Orders o ON od.order.order_id = o.order_id " +
                     "JOIN Dish d ON od.dish.dish_id = d.dish_id " +
                     "GROUP BY d.dish_name")
       List<SalesDTO> findDishSales();

       // Query για το συνολικό κέρδος μηνιαίως
       @Query("SELECT new com.example.demo.statistics.dto.TotalProfitDTO('Monthly', SUM(od.orderPerDish_quantity * (d.dish_price - di.ingredient_quantity * i.ingredient_cost))) "
                     +
                     "FROM OrderPerDish od " +
                     "JOIN Orders o ON od.order.order_id = o.order_id " +
                     "JOIN Dish d ON od.dish.dish_id = d.dish_id " +
                     "JOIN DishIngredients di ON d.dish_id = di.dish.dish_id " +
                     "JOIN Ingredient i ON di.ingredient.ingredient_id = i.ingredient_id " +
                     "WHERE o.order_datetime >= :startDate")
       List<TotalProfitDTO> findMonthlyTotalProfit(@Param("startDate") LocalDate startDate);

       // Query για το συνολικό κέρδος ετησίως
       @Query("SELECT new com.example.demo.statistics.dto.TotalProfitDTO('Annual', SUM(od.orderPerDish_quantity * (d.dish_price - di.ingredient_quantity * i.ingredient_cost))) "
                     +
                     "FROM OrderPerDish od " +
                     "JOIN Orders o ON od.order.order_id = o.order_id " +
                     "JOIN Dish d ON od.dish.dish_id = d.dish_id " +
                     "JOIN DishIngredients di ON d.dish_id = di.dish.dish_id " +
                     "JOIN Ingredient i ON di.ingredient.ingredient_id = i.ingredient_id " +
                     "WHERE o.order_datetime >= :startDate")
       List<TotalProfitDTO> findAnnualTotalProfit(@Param("startDate") LocalDate startDate);
>>>>>>> Stashed changes
}

// o.order_datetime >= :startDate "