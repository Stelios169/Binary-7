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
 
import com.example.demo.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import java.util.List;
import java.util.Optional;
 
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
 
   @Query("SELECT o FROM Orders o WHERE o.table.tableId.table_id = :table_id AND o.table.tableId.restaurant_id = :restaurant_id AND o.order_status = true")
    Optional<Orders> findByTableIdAndRestaurantIdAndOrderStatus(@Param("table_id") Integer tableId, @Param("restaurant_id") Integer restaurantId, @Param("order_status") Boolean orderStatus); 

    @Query("SELECT o FROM Orders o WHERE o.order_id = :order_id AND o.order_status = true")
    Optional<Orders> findById(@Param("order_id") Integer order_id);

    @Query("SELECT o FROM Orders o WHERE o.table.tableId.table_id = :table_id AND o.table.tableId.restaurant_id = :restaurant_id AND o.order_status = true")
    List<Orders> findAllByTableIdAndRestaurantIdAndOrderStatus(@Param("table_id") Integer tableId, @Param("restaurant_id") Integer restaurantId, @Param("order_status") Boolean orderStatus); 

}