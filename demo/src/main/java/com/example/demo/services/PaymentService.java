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
        Optional<Orders> activeOrders = ordersRepository.findByTableIdAndRestaurantIdAndOrderStatus(tableId, restaurantId, true);

        float totalAmount = 0;
        if (activeOrders.isPresent()) {
            Orders order = activeOrders.get();  // Εξαγωγή της παραγγελίας από το Optional
            totalAmount = order.getOrder_total();
            order.setOrder_status(false);  // Ενημέρωση της κατάστασης της παραγγελίας

            ordersRepository.save(order);  // Αποθήκευση της παραγγελίας
        }

        return totalAmount;
    } 
}
