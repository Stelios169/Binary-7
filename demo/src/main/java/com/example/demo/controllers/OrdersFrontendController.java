package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersFrontendController {
    @GetMapping("/create-order")
    public String showCreateOrderForm() {
        return "create-order";
    }
}
