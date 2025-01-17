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


    

