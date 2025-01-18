package com.example.demo.services;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Value;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
 
@SpringBootTest
@ActiveProfiles("test") // Ενεργοποίηση του προφίλ "test" για να φορτώσει το application-test.properties
public class SpoonacularPropertiesTest {
 
    @Autowired
    private SpoonacularProperties spoonacularProperties;
    
    @Value("${spoonacular.api.key}")
    private String apiKey;
    @Test
    public void testKeyLoading() {
        // Επαλήθευση ότι το API key φορτώνεται σωστά από τις ρυθμίσεις
        assertEquals("test-api-key", apiKey, "Το API key δεν φορτώθηκε σωστά!");
    }

    @Test
    public void debugLoadedProperties() {         
        // Εκτυπώνει το API key για debugging        
        System.out.println("Loaded API key: " + spoonacularProperties.getKey()); 
    }
}

