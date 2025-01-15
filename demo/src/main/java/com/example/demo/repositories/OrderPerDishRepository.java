package com.example.demo.repositories;

import com.example.demo.models.OrderPerDish;
import com.example.demo.models.DOid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
public interface OrderPerDishRepository extends JpaRepository<OrderPerDish, DOid> {

    @Modifying
    @Query("DELETE FROM OrderPerDish opd WHERE opd.order.order_id = :order_id")
    public void deleteByOrder_id(@Param("order_id") int orderId);

} 
    
    