package com.example.demo.services;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
 
@SpringBootTest
@ActiveProfiles("test") // Ενεργοποίηση του προφίλ "test" για να φορτώσει το application-test.properties
public class SpoonacularPropertiesTest {
 
    @Autowired
    private SpoonacularProperties spoonacularProperties;
 
    @Test
    public void testKeyLoading() {
        // Επαλήθευση ότι το API key φορτώνεται σωστά από τις ρυθμίσεις
        assertEquals("test-api-key", spoonacularProperties.getKey(), "Το API key δεν φορτώθηκε σωστά!");
    }
}

