package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login3Controller {
    @RequestMapping("/login")
    public String shwLoginForm() {
        return "login";
    }
}
