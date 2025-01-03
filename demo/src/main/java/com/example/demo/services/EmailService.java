package com.example.demo.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.models.Ingredient;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void sendExpiringIngredientsNotification(String to, String subject, List<Ingredient> ingredients, String text) {
        StringBuilder emailContent = new StringBuilder("The following ingredients that expire soon:\n\n");
        for (Ingredient ingredient : ingredients) {
            emailContent.append("- ").append(ingredient.getIngredient_name()).append(" (expiring: ").append(ingredient.getIngredient_exp_date()).append(")\n");
        }
        emailContent.append("\n Please use them.").append(text);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to); // Recipient
        message.setSubject(subject); // Subject
        message.setFrom("restaurantapp19@gmail.com"); // Sender
        message.setText(emailContent.toString()); // Add content to the email
    
        try {
            System.out.println("Sending email...");  // Debug print
            mailSender.send(message); // Send the email
            System.out.println("Email sent successfully");
        } catch (Exception e) {
            e.printStackTrace(); // Θα εμφανιστεί η ακριβής αιτία αποτυχίας
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}
