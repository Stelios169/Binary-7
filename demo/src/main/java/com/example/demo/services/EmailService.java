package com.example.demo.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.models.Ingredient;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;
    private final String emailSenderAddress;
    public EmailService(JavaMailSender mailSender, @Value("${email.sender.address}") String emailSenderAddress) {
        this.mailSender = mailSender;
        this.emailSenderAddress = emailSenderAddress;
    }
    public void sendExpiringIngredientsNotification(String to, String subject, List<Ingredient> ingredients, String text) {
        StringBuilder emailContent = new StringBuilder("The following ingredients will expire soon:\n\n");
        for (Ingredient ingredient : ingredients) {
            emailContent.append("- ").append(ingredient.getIngredient_name()).append(" (expiring: ").append(ingredient.getIngredient_exp_date()).append(")\n");
        }
        emailContent.append("\n Please use them.").append(text);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to); // Recipient
        message.setSubject(subject); // Subject
        message.setFrom(emailSenderAddress); // Sender
        message.setText(emailContent.toString()); // Add content to the email
    
        try {
            logger.info("Sending email to {}", to);  // Debug print
            mailSender.send(message); // Send the email
            logger.info("Email sent successfully to {} ",  to);
        } catch (Exception e) {
            logger.error("Error sending email to {}: {} ", to, e.getMessage(), e);
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
