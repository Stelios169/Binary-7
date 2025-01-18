package com.example.demo.services;

import com.example.demo.models.Ingredient;
import com.example.demo.models.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class ScheduledEmailServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledEmailServiceTest.class);

    @InjectMocks
    private ScheduledEmailService scheduledEmailService;

    @Mock
    private EmailService emailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendDailyExpiringIngredientsEmail_NoRestaurants() {
        // Mock empty restaurant list
        when(emailService.findRestaurantsWithExpiringIngredients(any(LocalDate.class)))
                .thenReturn(Collections.emptyList());

        scheduledEmailService.sendDailyExpiringIngredientsEmail();

        // Verify no emails are sent
        verify(emailService, never()).sendExpiringIngredientsNotification(anyString(), anyString(), anyList());
        logger.info("Test for no restaurants passed.");
    }

    @Test
    void testSendDailyExpiringIngredientsEmail_RestaurantsWithNoExpiringIngredients() {
        // Mock restaurant list
        Restaurant restaurant = new Restaurant(1, "password123", "Test Restaurant", "123 Test Street",
                "test@example.com", 4.5, 123456789L, 987654321L);
        when(emailService.findRestaurantsWithExpiringIngredients(any(LocalDate.class)))
                .thenReturn(Arrays.asList(restaurant));

        // Mock no expiring ingredients for the restaurant
        when(emailService.findExpiringIngredientsForRestaurant(eq(1), any(LocalDate.class)))
                .thenReturn(Collections.emptyList());

        scheduledEmailService.sendDailyExpiringIngredientsEmail();

        // Verify no emails are sent
        verify(emailService, never()).sendExpiringIngredientsNotification(anyString(), anyString(), anyList());
        logger.info("Test for restaurants with no expiring ingredients passed.");
    }

    @Test
    void testSendDailyExpiringIngredientsEmail_RestaurantsWithExpiringIngredients() {
        // Mock restaurant list
        Restaurant restaurant = new Restaurant(1, "password123", "Test Restaurant", "123 Test Street",
                "test@example.com", 4.5, 123456789L, 987654321L);
        when(emailService.findRestaurantsWithExpiringIngredients(any(LocalDate.class)))
                .thenReturn(Arrays.asList(restaurant));

        // Mock expiring ingredients for the restaurant
        Ingredient ingredient1 = new Ingredient("Tomato", 10.0, 101, 1.5, "kg", LocalDate.now().plusDays(3));
        Ingredient ingredient2 = new Ingredient("Lettuce", 5.0, 102, 0.8, "kg", LocalDate.now().plusDays(5));
        List<Ingredient> expiringIngredients = Arrays.asList(ingredient1, ingredient2);
        when(emailService.findExpiringIngredientsForRestaurant(eq(1), any(LocalDate.class)))
                .thenReturn(expiringIngredients);

        scheduledEmailService.sendDailyExpiringIngredientsEmail();

        // Verify email is sent with the correct details
        verify(emailService, times(1)).sendExpiringIngredientsNotification(
                eq("test@example.com"),
                eq("Expiring Ingredients Notification"),
                eq(expiringIngredients)
        );
        logger.info("Test for restaurants with expiring ingredients passed.");
    }

    @Test
    void testSendDailyExpiringIngredientsEmail_ExceptionHandling() {
        // Mock an exception when finding restaurants
        when(emailService.findRestaurantsWithExpiringIngredients(any(LocalDate.class)))
                .thenThrow(new RuntimeException("Database error"));

        scheduledEmailService.sendDailyExpiringIngredientsEmail();

        // Verify no emails are sent and exception is logged
        verify(emailService, never()).sendExpiringIngredientsNotification(anyString(), anyString(), anyList());
        logger.info("Test for exception handling passed.");
    }
}
