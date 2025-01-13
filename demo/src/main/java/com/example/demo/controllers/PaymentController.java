package com.example.demo.controllers;

import com.example.demo.services.PaymentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public String processPayment(@RequestParam int tableId, @RequestParam int restaurantId, Model model) {
        float totalAmount = paymentService.processPayment(tableId, restaurantId);

        if (totalAmount > 0) {
            model.addAttribute("message", String.format("Payment successful. Total amount: %.2f€", totalAmount));
        } else {
            model.addAttribute("message", "No active orders for this table.");
        }
        
        return "paymentResult";
    }
}
