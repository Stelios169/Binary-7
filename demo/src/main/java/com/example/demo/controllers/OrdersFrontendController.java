package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersFrontendController {
    @GetMapping("/menu/create")
    public String showCreateOrderForm() {
        return "create";
    }

    @GetMapping("/menu/payment")
    public String showPaymentOrderForm() {
        return "payment";
    }
}
