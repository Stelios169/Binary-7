package com.example.demo.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.models.Ingredient;
import com.example.demo.models.Restaurant;
import com.example.demo.repositories.IngredientRepository;
import com.example.demo.repositories.RestaurantRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;
    private final IngredientRepository ingredientRepository;
    private final RestaurantRepository restaurantRepository;
    private final String emailSenderAddress;
    @Autowired
    public EmailService(JavaMailSender mailSender, IngredientRepository ingredientRepository, RestaurantRepository restaurantRepository, @Value("${email.sender.address}") String emailSenderAddress) {
        this.mailSender = mailSender;
        this.ingredientRepository = ingredientRepository;
        this.restaurantRepository = restaurantRepository;
        this.emailSenderAddress = emailSenderAddress;
    }
    public List<Restaurant> findRestaurantsWithExpiringIngredients(LocalDate expiryThreshold) {
        List<Restaurant> restaurants = restaurantRepository.findRestaurantsWithExpiringIngredients(expiryThreshold);
        if (restaurants.isEmpty()) {
            System.out.println("No restaurants found with expiring ingredients ");
        } else {
            System.out.println("Found restaurants with expiring ingredients");
        }
        return restaurants;

        //return restaurantRepository.findRestaurantsWithExpiringIngredients(expiryThreshold);
    }

    public List<Ingredient> findExpiringIngredientsForRestaurant(int restaurantId, LocalDate expiryThreshold) {
        List<Ingredient> ingredients = ingredientRepository.findExpiringIngredientsForRestaurant(restaurantId, expiryThreshold);
        if (ingredients.isEmpty()) {   
            logger.debug("No expiring ingredients found for restaurant ID {} before {}", restaurantId, expiryThreshold);
        } else {
            logger.debug("Found expiring ingredients for restaurant ID {}: {}", restaurantId, ingredients);
        }
        return ingredients;
    }
        //return ingredientRepository.findExpiringIngredientsForRestaurant(restaurantId, expiryThreshold);

    //sendNotificationEmail
    public void sendExpiringIngredientsNotification(String to, String subject, List<Ingredient> ingredients) {
        StringBuilder emailContent = new StringBuilder("The following ingredients will expire soon:\n\n");
        for (Ingredient ingredient : ingredients) {
            emailContent.append("- ").append(ingredient.getIngredient_name()).append(" (expiring: ").append(ingredient.getIngredient_exp_date()).append(")\n");
        }
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

    