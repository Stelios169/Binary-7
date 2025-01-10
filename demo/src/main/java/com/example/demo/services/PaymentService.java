package com.example.demo.services;

import com.example.demo.models.Orders;
import com.example.demo.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final OrdersRepository ordersRepository;

    public PaymentService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public float processPayment(int tableId, int restaurantId) {
        List<Orders> activeOrders = ordersRepository.findByTableIdAndRestaurantIdAndOrderStatus(tableId, restaurantId, true);

        float totalAmount = 0;
        for (Orders orders : activeOrders) {
            totalAmount += orders.getOrder_total();
            orders.setOrder_status(false);
        }

        if (!activeOrders.isEmpty()) {
            ordersRepository.saveAll(activeOrders);
        }

        return totalAmount;
    } 
}
