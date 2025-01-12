package com.example.demo.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Restaurant;
import com.example.demo.repositories.RestaurantRepository;
import java.util.Optional;
import org.springframework.ui.Model;

@Controller
public class Login2Controller {

    private final RestaurantRepository restaurantRepository;
    public Login2Controller(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    /*@Autowired
    private LoginService loginService;*/

    @PostMapping("/login")
    public String processLogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {
                 Optional<Restaurant> restaurant = restaurantRepository.findByEmail(email);
                 if (restaurant.isPresent()) {
                    if (restaurant.get().getRestaurant_password().equals(password)) {
                        return "tables"; // Redirect if login successful
                    } else {
                        model.addAttribute("error", "Invalid password");
                        return "login";
                    }
                } else {
                    model.addAttribute("error", "Email not found");
                    return "login";
                }
            }


                /*if (loginService.validateLogin(email, password)) {
                    return "tables"; // Αν η σύνδεση είναι επιτυχής
                } else {
                    model.addAttribute("error", "Invalid email or password");
                    return "login"; // Επιστροφή στη φόρμα με μήνυμα λάθους
                }
            }*/

        

    }


