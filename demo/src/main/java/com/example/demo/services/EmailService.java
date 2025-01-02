package com.example.demo.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to); // Recipient
        message.setSubject(subject); // Subject
        message.setText(text); // Email body
        message.setFrom("restaurantapp19@gmail.com"); // Sender
        try {
            mailSender.send(message); // Send the email
            System.out.println("Email sent successfully");
        } catch (Exception e) {
            e.printStackTrace(); // Θα εμφανιστεί η ακριβής αιτία αποτυχίας
            System.err.println("Error sending email: " + e.getMessage());
        }
    }    
}
