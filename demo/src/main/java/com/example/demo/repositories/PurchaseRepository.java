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
