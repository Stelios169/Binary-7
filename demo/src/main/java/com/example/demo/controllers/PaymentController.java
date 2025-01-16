package com.example.demo.controllers;

import com.example.demo.services.PaymentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public String processPayment(@RequestParam int tableId, @RequestParam int restaurantId, Model model) {
        float totalAmount = paymentService.processPayment(tableId, restaurantId);

        if (totalAmount > 0) {
            model.addAttribute("message", String.format("Payment successful. Total amount: %.2f€", totalAmount));
        } else {
            model.addAttribute("error", "No active orders for this table.");
        }

        return "payment";
    }
}
