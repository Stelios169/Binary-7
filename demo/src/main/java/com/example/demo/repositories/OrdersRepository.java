package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Orders;
 
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByTableIdAndRestaurantIdAndOrderStatus(int tableId, int restaurantId, boolean b);
   
}