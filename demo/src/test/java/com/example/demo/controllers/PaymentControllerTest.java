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

package com.example.demo.controllers;


import com.example.demo.services.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;



class PaymentControllerTest {

    @Test
    void testProcessPayment_Success() {
        // Mock dependencies
        PaymentService mockPaymentService = Mockito.mock(PaymentService.class);
        Model mockModel = Mockito.mock(Model.class);

        // Test data
        int tableId = 1;
        int restaurantId = 101;
        float totalAmount = 50.75f;

        // Stub the service method
        Mockito.when(mockPaymentService.processPayment(tableId, restaurantId)).thenReturn(totalAmount);

        // Instantiate the controller
        PaymentController paymentController = new PaymentController(mockPaymentService);

        // Call the method under test
        String viewName = paymentController.processPayment(tableId, restaurantId, mockModel);

        // Verify interactions and assertions
        Mockito.verify(mockModel).addAttribute(eq("message"), eq(String.format("Payment successful. Total amount: %.2f€", totalAmount)));
        assertEquals("payment", viewName);
    }

    @Test
    void testProcessPayment_NoActiveOrders() {
        // Mock dependencies
        PaymentService mockPaymentService = Mockito.mock(PaymentService.class);
        Model mockModel = Mockito.mock(Model.class);

        // Test data
        int tableId = 1;
        int restaurantId = 101;

        // Stub the service method
        Mockito.when(mockPaymentService.processPayment(tableId, restaurantId)).thenReturn(0f);

        // Instantiate the controller
        PaymentController paymentController = new PaymentController(mockPaymentService);

        // Call the method under test
        String viewName = paymentController.processPayment(tableId, restaurantId, mockModel);

        // Verify interactions and assertions
        Mockito.verify(mockModel).addAttribute(eq("error"), eq("No active orders for this table."));
        assertEquals("payment", viewName);
    }
}


    

