package com.example.demo.repositories;
 
import com.example.demo.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import java.util.List;
 
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
 
    @Query("SELECT o FROM Orders o WHERE o.table.tableId.table_id = :tableId AND o.table.tableId.restaurant_id = :restaurantId AND o.order_status = true")
    List<Orders> findByTableIdAndRestaurantIdAndOrderStatus(@Param("tableId") int tableId, @Param("restaurantId") int restaurantId, @Param("orderStatus") boolean orderStatus);
}