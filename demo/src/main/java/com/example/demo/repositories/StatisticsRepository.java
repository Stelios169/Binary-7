package com.example.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StatisticsRepository extends JpaRepository<Object, Long>  {
    @Query("""
    SELECT d.dish_name AS dish_name
    FROM OrderPerDish opd
    JOIN opd.order o
    JOIN opd.dish d
    WHERE o.order_datetime >= CURRENT_DATE - 7
    GROUP BY d.dish_name
    ORDER BY SUM(opd.orderPerDish_quantity) DESC
    """)
    List<Object[]> getFavoriteDishWeekly();

    @Query("""
        SELECT d.dish_name AS dish_name, SUM(opd.orderPerDish_quantity) AS totalOrders
        FROM OrderPerDish opd
        JOIN opd.order o
        JOIN opd.dish d
        WHERE o.order_datetime >= CURRENT_DATE - 30
        GROUP BY d.dish_name
        ORDER BY totalOrders DESC
    """)
    List<Object[]> getFavoriteDishMonthly();

    @Query("""
    SELECT d.dish_name AS dish_name, SUM(opd.orderPerDish_quantity * d.price) AS sales
    FROM OrderPerDish opd
    JOIN opd.dish d
    GROUP BY d.dish_name
    ORDER BY sales DESC
    """)
    List<Object[]> getSalesPerDish();

    @Query("""
    SELECT d.dish_name AS dish_name, 
           SUM(di.ingredient_quantity * i.cost) AS cost, 
           SUM(opd.orderPerDish_quantity * d.price) - SUM(di.ingredient_quantity * i.cost) AS profit
    FROM OrderPerDish opd
    JOIN opd.dish d
    JOIN d.ingredients di
    JOIN di.ingredient i
    GROUP BY d.dish_name
    ORDER BY profit DESC
    """)
    List<Object[]> getCostAndProfitPerDish();

    @Query("""
    SELECT SUM(opd.orderPerDish_quantity * d.price) - SUM(di.ingredient_quantity * i.cost) AS totalProfit
    FROM OrderPerDish opd
    JOIN opd.dish d
    JOIN d.ingredients di
    JOIN di.ingredient i
    JOIN opd.order o
    WHERE o.order_datetime >= CURRENT_DATE - INTERVAL '1 MONTH'
    """)
    Double getTotalProfitMonthly();

    @Query("""
    SELECT AVG(DATEDIFF(CURRENT_DATE, i.ingredient_exp_date)) AS avgRestockTime
    FROM Purchase p
    JOIN p.ingredient i
    """)
    Double getAvgRestockTime();





}
