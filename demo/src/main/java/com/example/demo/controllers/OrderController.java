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

import com.example.demo.models.Orders;
import com.example.demo.services.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/menu")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public String createOrder(@RequestParam int tableId,
            @RequestParam int restaurantId,
            Model model) {
        try {
            Orders order = orderService.createOrder(tableId, restaurantId);

            model.addAttribute("orderId", order.getOrder_id());

            return "add-dish";
        } catch (Exception e) {
            model.addAttribute("error", "Could not create order. Please check the table and restaurant IDs.");
            return "create";
        }
    }

    @PostMapping("/{orderId}/add-dish")
    public String addDishToOrder(@RequestParam int dishId,
            @PathVariable int orderId,
            @RequestParam int quantity,
            Model model) {
        try {
            // Προσθήκη του πιάτου στην παραγγελία
            orderService.addDishToOrder(dishId, orderId, quantity);

            // Επιστροφή στην ίδια σελίδα για να προσθέσει άλλα πιάτα
            model.addAttribute("orderId", orderId);
            model.addAttribute("message", "Dish added successfully!");
            return "add-dish";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Error: " + e.getMessage());
            return "add-dish"; // Επιστροφή αν υπάρχει σφάλμα
        }
    }

    // "error", "Could not find a dish with this Id"
    // @PostMapping("/create")
    // public ResponseEntity<Orders> createOrder(
    // @RequestParam int tableId,
    // @RequestParam int restaurantId) {
    // Orders order = orderService.createOrder(tableId, restaurantId);
    // return ResponseEntity.ok(order);
    // }

    // @PostMapping("/{orderId}/add-dish")
    // public ResponseEntity<String> addDishToOrder(
    // @PathVariable int orderId,
    // @RequestParam int dishId,
    // @RequestParam int quantity) {
    // try {
    // orderService.addDishToOrder(orderId, dishId, quantity);
    // return ResponseEntity.ok("Dish added successfully to the order.");
    // } catch (RuntimeException e) {
    // return ResponseEntity.badRequest().body(e.getMessage());
    // }
    // }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> removeOrder(@PathVariable Integer orderId) {
        try {
            orderService.removeOrder(orderId);
            return ResponseEntity.ok("Order removed successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
