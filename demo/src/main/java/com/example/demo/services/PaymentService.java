package com.example.demo.services;

import com.example.demo.models.Orders;
import com.example.demo.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final OrdersRepository ordersRepository;

    public PaymentService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public float processPayment(int tableId, int restaurantId) {
        // Fetch orders: 0, single or multiple
        List<Orders> multipleOrders = ordersRepository.findAllByTableIdAndRestaurantIdAndOrderStatus(tableId, restaurantId, true);

        float totalAmount = 0;

        if (!multipleOrders.isEmpty()) {

            for (Orders order : multipleOrders) {
                totalAmount += order.getOrder_total();
                order.setOrder_status(false);
                ordersRepository.save(order);
            }
        }

        return totalAmount;
    }
}
