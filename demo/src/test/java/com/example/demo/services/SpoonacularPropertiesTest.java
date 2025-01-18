/*
 * Copyright 2024-2025 Binary 7
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo.services;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

