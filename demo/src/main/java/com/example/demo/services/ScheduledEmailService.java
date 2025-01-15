package com.example.demo.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.models.Ingredient;
import com.example.demo.models.Restaurant;
import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduledEmailService {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledEmailService.class);
    private final EmailService emailService;

    @Autowired
    public ScheduledEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Scheduled method to send emails every day at 9:00 AM.
     * The cron expression follows the format: second, minute, hour, day, month, day-of-week.
     */
    @Scheduled(cron = "0 0 9 * * ?")
    public void sendDailyExpiringIngredientsEmail() {
        try {
            // Ορισμός του χρονικού ορίου (7 ημέρες από σήμερα)
            LocalDate expiryThreshold = LocalDate.now().plusDays(7);

            // Εύρεση εστιατορίων με υλικά που λήγουν σύντομα
            List<Restaurant> restaurants = emailService.findRestaurantsWithExpiringIngredients(expiryThreshold);

            if (restaurants.isEmpty()) {
                logger.info("No restaurants with expiring ingredients for today.");
                return;
            }

            for (Restaurant restaurant : restaurants) {
                List<Ingredient> expiringIngredients = emailService.findExpiringIngredientsForRestaurant(restaurant.getRestaurant_id(), expiryThreshold);
                if (!expiringIngredients.isEmpty()) {
                    emailService.sendExpiringIngredientsNotification(restaurant.getRestaurant_email(), "Expiring Ingredients Notification", expiringIngredients);
                }
            }
            logger.info("Daily email job completed successfully.");
        } catch (Exception e) {
            logger.error("Error occurred during the daily email job: {}", e.getMessage(), e);
        }
    }
}
