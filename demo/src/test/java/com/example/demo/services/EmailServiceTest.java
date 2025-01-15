package com.example.demo.services;
    
import com.example.demo.models.Ingredient;
import com.example.demo.repositories.IngredientRepository;
import com.example.demo.repositories.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Arrays;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
   
public class EmailServiceTest {
    
    private final JavaMailSender mailSender = Mockito.mock(JavaMailSender.class);
    private final IngredientRepository ingredientRepository = Mockito.mock(IngredientRepository.class);
    private final RestaurantRepository restaurantRepository = Mockito.mock(RestaurantRepository.class);
    
    private final EmailService emailService = new EmailService(mailSender, ingredientRepository, restaurantRepository, "restaurantapp19@gmail.com");
    
    @Test
    void testFindRestaurantsWithExpiringIngredients_NoResults() {
        when(restaurantRepository.findRestaurantsWithExpiringIngredients(any())).thenReturn(Collections.emptyList());
    
        var result = emailService.findRestaurantsWithExpiringIngredients(LocalDate.now().plusDays(7));
    
        assertEquals(0, result.size());
        verify(restaurantRepository, times(1)).findRestaurantsWithExpiringIngredients(any());
    }
    
    @Test
    void testSendExpiringIngredientsNotification_Success() {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredient_name("Salmon");
        ingredient.setIngredient_exp_date(LocalDate.now().plusDays(3));
    
        emailService.sendExpiringIngredientsNotification("stella.panopoulou678@gmail.com", "Expiring Ingredients: ", Arrays.asList(ingredient));
    
        // Verify email content
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}
