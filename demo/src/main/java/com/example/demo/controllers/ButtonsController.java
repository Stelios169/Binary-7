package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
public class ButtonsController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }
}
