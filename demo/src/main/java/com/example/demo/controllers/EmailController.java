package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repositories.DishRepository;
import com.example.demo.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.repositories.DishRepository;

@Controller
@RestController
@RequestMapping("/api")
public class EmailController {
    private final EmailService emailService;
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam String to,
                            @RequestParam String subject,
                            @RequestParam String text) {
        try{
            emailService.sendSimpleEmail(to, subject, text);
            return "Email sent successfully to " + to;
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send email";
        }
    }    
}
