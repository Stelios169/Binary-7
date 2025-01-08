package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Purchase;
import com.example.demo.statistics.dto.AverageStockTimeDTO;
import java.util.List;
 
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Query(value = "SELECT i.ingredient_name, " +
    "AVG(TIMESTAMPDIFF(DAY, p.purchase_date, LEAD(p.purchase_date) OVER (PARTITION BY p.ingredient.ingredient_id ORDER BY p.purchase_date))) " +
    "FROM Purchase p " +
    "JOIN Ingredient i ON p.ingredient.ingredient_id = i.ingredient_id " +
    "WHERE p.purchase_date IS NOT NULL " +
    "GROUP BY i.ingredient_name", nativeQuery = true)
List<AverageStockTimeDTO> findAverageStockReplenishmentTimeNative();

}
