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

        Orders order = orderService.createOrder(tableId, restaurantId);

        model.addAttribute("orderId", order.getOrder_id());

        return "add-dish";
    }

    @PostMapping("/{orderId}/add-dish")
    public String addDishToOrder(@PathVariable int orderId,
            @RequestParam int dishId,
            @RequestParam int quantity,
            Model model) {
        try {
            // Προσθήκη του πιάτου στην παραγγελία
            orderService.addDishToOrder(orderId, dishId, quantity);

            // Επιστροφή στην ίδια σελίδα για να προσθέσει άλλα πιάτα
            model.addAttribute("orderId", orderId);
            model.addAttribute("message", "Dish added successfully!");
            return "add-dish";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "add-dish"; // Επιστροφή αν υπάρχει σφάλμα
        }
    }

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
