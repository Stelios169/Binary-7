package com.example.demo.services;

import com.example.demo.models.Orders;
import com.example.demo.repositories.OrdersRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


class PaymentServiceTest {

    @Test
    void testProcessPayment_OrderExists() {
        // Mock dependencies
        OrdersRepository mockOrdersRepository = Mockito.mock(OrdersRepository.class);

        // Test data
        int tableId = 1;
        int restaurantId = 101;
        float orderTotal = 75.50f;

        // Mock order
        Orders mockOrder = new Orders();
        mockOrder.setOrder_total(orderTotal);
        mockOrder.setOrder_status(true);

        // Stub the repository method
        Mockito.when(mockOrdersRepository.findByTableIdAndRestaurantIdAndOrderStatus(tableId, restaurantId, true))
                .thenReturn(Optional.of(mockOrder));

        // Instantiate the service
        PaymentService paymentService = new PaymentService(mockOrdersRepository);

        // Call the method under test
        float result = paymentService.processPayment(tableId, restaurantId);

        // Verify interactions and assertions
        Mockito.verify(mockOrdersRepository).save(mockOrder);
        assertEquals(orderTotal, result);
        assertEquals(false, mockOrder.isOrder_status());
    }

    @Test
    void testProcessPayment_NoActiveOrder() {
        // Mock dependencies
        OrdersRepository mockOrdersRepository = Mockito.mock(OrdersRepository.class);

        // Test data
        int tableId = 1;
        int restaurantId = 101;

        // Stub the repository method
        Mockito.when(mockOrdersRepository.findByTableIdAndRestaurantIdAndOrderStatus(tableId, restaurantId, true))
                .thenReturn(Optional.empty());

        // Instantiate the service
        PaymentService paymentService = new PaymentService(mockOrdersRepository);

        // Call the method under test
        float result = paymentService.processPayment(tableId, restaurantId);

        // Verify interactions and assertions
        Mockito.verify(mockOrdersRepository, Mockito.never()).save(any());
        assertEquals(0f, result);
    }
}
