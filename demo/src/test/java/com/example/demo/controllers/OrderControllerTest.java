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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
 
class OrderControllerTest {
 
    /*@Mock
    private OrderService orderService;
 
    @Mock
    private Model model;
 
    @InjectMocks
    private OrderController orderController;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void createOrder_Success() {
        int tableId = 1;
        int restaurantId = 1;
        Orders mockOrder = new Orders();
        mockOrder.setOrder_id(10);
 
        when(orderService.createOrder(tableId, restaurantId)).thenReturn(mockOrder);
 
        String result = orderController.createOrder(tableId, restaurantId, model);
 
        verify(orderService).createOrder(tableId, restaurantId);
        verify(model).addAttribute("orderId", mockOrder.getOrder_id());
        assertEquals("add-dish", result);
    }
 
    @Test
    void createOrder_Failure() {
        int tableId = 1;
        int restaurantId = 1;
 
        when(orderService.createOrder(tableId, restaurantId)).thenThrow(new RuntimeException("Error"));
 
        String result = orderController.createOrder(tableId, restaurantId, model);
 
        verify(model).addAttribute("error", "Could not create order. Please check the table and restaurant IDs.");
        assertEquals("create", result);
    }
 
    @Test
    void addDishToOrder_Success() {
        int dishId = 1;
        int orderId = 10;
        int quantity = 2;
 
        String result = orderController.addDishToOrder(dishId, orderId, quantity, model);
 
        verify(orderService).addDishToOrder(dishId, orderId, quantity);
        verify(model).addAttribute("orderId", orderId);
        verify(model).addAttribute("message", "Dish added successfully!");
        assertEquals("add-dish", result);
    }
 
    @Test
    void addDishToOrder_Failure() {
        int dishId = 1;
        int orderId = 10;
        int quantity = 2;
 
        doThrow(new RuntimeException("Error")).when(orderService).addDishToOrder(dishId, orderId, quantity);
 
        String result = orderController.addDishToOrder(dishId, orderId, quantity, model);
 
        verify(model).addAttribute("error", "Error: Error");
        assertEquals("add-dish", result);
    }
 
    @Test
    void removeOrder_Success() {
        int orderId = 10;
 
        ResponseEntity<String> response = orderController.removeOrder(orderId);
 
        verify(orderService).removeOrder(orderId);
        assertEquals(ResponseEntity.ok("Order removed successfully."), response);
    }
 
    @Test
    void removeOrder_Failure() {
        int orderId = 10;
 
        doThrow(new RuntimeException("Error")).when(orderService).removeOrder(orderId);
 
        ResponseEntity<String> response = orderController.removeOrder(orderId);
 
        assertEquals(ResponseEntity.badRequest().body("Error"), response);
    }*/
}
 
