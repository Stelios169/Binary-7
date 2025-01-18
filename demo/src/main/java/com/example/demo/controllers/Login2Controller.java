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


