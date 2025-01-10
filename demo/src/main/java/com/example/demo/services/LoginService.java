package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.RestaurantRepository;
import com.example.demo.models.Restaurant;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private RestaurantRepository repository;

    public boolean validateLogin(String email, String password) {
        Optional<Restaurant> ownerOptional = repository.findByEmail(email);
        if (ownerOptional.isPresent()) {
            Restaurant owner = ownerOptional.get();
            return owner.getRestaurant_password().equals(password);
        }
        return false;
    }
}    
