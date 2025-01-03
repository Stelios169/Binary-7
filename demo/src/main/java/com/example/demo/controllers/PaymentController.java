package com.example.demo.controllers;

import com.example.demo.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public String processPayment(@RequestParam int tableId, @RequestParam int restaurantId) {
        float totalAmount = paymentService.processPayment(tableId, restaurantId);

        if (totalAmount > 0) {
            return String.format("Payment successful. Total amount: %.2f€", totalAmount);
        } else {
            return "No active orders for this table.";
        }
    } 
}
