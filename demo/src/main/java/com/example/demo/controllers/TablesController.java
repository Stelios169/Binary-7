package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TablesController {
    @RequestMapping("/tables")
    public String login() {
        return "tables";
    }

    @RequestMapping("/ingredients")
    public String ingr() {
        return "ingredients";
    }

    @RequestMapping("/statistics")
    public String stats() {
        return "statistics";
    }
}
