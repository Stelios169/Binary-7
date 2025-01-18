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

import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PaymentServiceTest {

    @Test
    void testProcessPayment_OrderExists() {
        // Mock dependencies
        OrdersRepository mockOrdersRepository = Mockito.mock(OrdersRepository.class);
    
        // Test data
        int tableId = 1;
        int restaurantId = 101;
        float orderTotal1 = 75.50f;
        float orderTotal2 = 50.00f;
    
        // Mock orders
        Orders mockOrder1 = new Orders(1,orderTotal1, true,LocalDateTime.now());
        mockOrder1.setOrder_total(orderTotal1);
        mockOrder1.setOrder_status(true);
    
        Orders mockOrder2 = new Orders(2, orderTotal2, true, LocalDateTime.now());
        mockOrder2.setOrder_total(orderTotal2);
        mockOrder2.setOrder_status(true);
    
        // Stub the repository method
        Mockito.when(mockOrdersRepository.findAllByTableIdAndRestaurantIdAndOrderStatus(tableId, restaurantId, true))
                .thenReturn(List.of(mockOrder1, mockOrder2));
    
        // Instantiate the service
        PaymentService paymentService = new PaymentService(mockOrdersRepository);
    
        // Call the method under test
        float result = paymentService.processPayment(tableId, restaurantId);
    
        // Verify interactions and assertions
        Mockito.verify(mockOrdersRepository).save(mockOrder1); // Verify save for the first order
        Mockito.verify(mockOrdersRepository).save(mockOrder2); // Verify save for the second order
        assertEquals(orderTotal1 + orderTotal2, result); // Ensure total amount matches
        assertEquals(false, mockOrder1.isOrder_status()); // Ensure first order status is updated
        assertEquals(false, mockOrder2.isOrder_status()); // Ensure second order status is updated
    }
    
}
