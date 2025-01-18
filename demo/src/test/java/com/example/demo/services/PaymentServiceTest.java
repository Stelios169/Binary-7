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

package com.example.demo.services;

import com.example.demo.models.Orders;
import com.example.demo.repositories.OrdersRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


class PaymentServiceTest {
/* 
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
    }*/
}
