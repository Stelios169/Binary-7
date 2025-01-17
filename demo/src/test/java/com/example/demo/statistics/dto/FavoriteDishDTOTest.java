package com.example.demo.statistics.dto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FavoriteDishDTOTest {
    // Τεστ για δημιουργία αντικειμένου και έλεγχο getters
    @Test
    void testConstructorAndGetters() {
        // Δημιουργούμε το αντικείμενο με constructor
        FavoriteDishDTO favoriteDish = new FavoriteDishDTO("Pizza", 50L);
        
        // Ελέγχουμε αν οι getters επιστρέφουν τις σωστές τιμές
        assertEquals("Pizza", favoriteDish.getDishName());
        assertEquals(50L, favoriteDish.getTotalQuantity());
    }

    // Τεστ για τον setter για το dish_name
    @Test
    void testSetDishName() {
        // Δημιουργούμε το αντικείμενο
        FavoriteDishDTO favoriteDish = new FavoriteDishDTO("Pizza", 50L);
        
        // Αλλάζουμε το dish_name μέσω του setter
        favoriteDish.setDishName("Burger");
        
        // Ελέγχουμε αν το dish_name άλλαξε σωστά
        assertEquals("Burger", favoriteDish.getDishName());
    }

    // Τεστ για τον setter για το totalQuantity
    @Test
    void testSetTotalQuantity() {
        // Δημιουργούμε το αντικείμενο
        FavoriteDishDTO favoriteDish = new FavoriteDishDTO("Pizza", 50L);
        
        // Αλλάζουμε το totalQuantity μέσω του setter
        favoriteDish.setTotalQuantity(100L);
        
        // Ελέγχουμε αν το totalQuantity άλλαξε σωστά
        assertEquals(100L, favoriteDish.getTotalQuantity());
    }

    // Τεστ για την ισότητα αντικειμένων (εάν η κλάση FavoriteDishDTO υλοποιεί equals)
    @Test
    void testEquals() {
        // Δημιουργούμε δύο αντικείμενα με τις ίδιες τιμές
        FavoriteDishDTO dish1 = new FavoriteDishDTO("Pizza", 50L);
        FavoriteDishDTO dish2 = new FavoriteDishDTO("Pizza", 50L);
        
        // Ελέγχουμε αν τα δύο αντικείμενα είναι ίσα
        assertEquals(dish1, dish2);
    }

    // Τεστ για αν το αντικείμενο είναι διαφορετικό από null
    @Test
    void testNotEqualsNull() {
        // Δημιουργούμε το αντικείμενο
        FavoriteDishDTO favoriteDish = new FavoriteDishDTO("Pizza", 50L);
        
        // Ελέγχουμε αν το αντικείμενο δεν είναι ίσο με null
        assertNotNull(favoriteDish);
    }

    // Τεστ για hashCode (αν η κλάση FavoriteDishDTO υλοποιεί το hashCode)
    @Test
    void testHashCode() {
        // Δημιουργούμε δύο αντικείμενα με τις ίδιες τιμές
        FavoriteDishDTO dish1 = new FavoriteDishDTO("Pizza", 50L);
        FavoriteDishDTO dish2 = new FavoriteDishDTO("Pizza", 50L);
        
        // Ελέγχουμε αν τα δύο αντικείμενα έχουν το ίδιο hashCode
        assertEquals(dish1.hashCode(), dish2.hashCode());
    }
}
