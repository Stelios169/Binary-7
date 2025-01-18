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
 
import com.example.demo.models.*;
import com.example.demo.repositories.DishRepository;
import com.example.demo.repositories.OrderPerDishRepository;
import com.example.demo.repositories.OrdersRepository;
import com.example.demo.repositories.RTableRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import java.time.LocalDateTime;
import java.util.Optional;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
class OrderServiceTest {
   /*  @Mock
    private OrdersRepository ordersRepository;
 
    @Mock
    private OrderPerDishRepository orderPerDishRepository;
 
    @Mock
    private DishRepository dishRepository;
 
    @Mock
    private RTableRepository rTableRepository;
 
    @InjectMocks
    private OrderService orderService;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void createOrder_Success() {
        int tableId = 1;
        int restaurantId = 1;
        TId tableKey = new TId(tableId, restaurantId);
        RTable mockTable = new RTable();
        mockTable.setTableId(tableKey);
 
        when(rTableRepository.findById(tableKey)).thenReturn(Optional.of(mockTable));
        when(ordersRepository.findByTableIdAndRestaurantIdAndOrderStatus(tableId, restaurantId, true))
                .thenReturn(Optional.empty());
 
        Orders mockOrder = new Orders();
        when(ordersRepository.save(any(Orders.class))).thenReturn(mockOrder);
 
        Orders result = orderService.createOrder(tableId, restaurantId);
 
        verify(ordersRepository).save(any(Orders.class));
        assertNotNull(result);
    }
 
    @Test
    void createOrder_TableNotFound() {
        int tableId = 1;
        int restaurantId = 1;
        TId tableKey = new TId(tableId, restaurantId);
 
        when(rTableRepository.findById(tableKey)).thenReturn(Optional.empty());
 
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> orderService.createOrder(tableId, restaurantId));
 
        assertEquals("Table not found with tableId: 1 and restaurantId: 1", exception.getMessage());
    }
 
    @Test
    void addDishToOrder_Success() {
        int dishId = 1;
        int orderId = 10;
        int quantity = 2;
 
        Orders mockOrder = new Orders();
        mockOrder.setOrder_id(orderId);
        mockOrder.setOrder_total(0.0f);
 
        Dish mockDish = new Dish();
        mockDish.setDish_id(dishId);
        mockDish.setDish_price(10.0f);
        mockDish.setDish_availability(true);
 
        when(ordersRepository.findById(orderId)).thenReturn(Optional.of(mockOrder));
        when(dishRepository.findById(dishId)).thenReturn(Optional.of(mockDish));
 
        orderService.addDishToOrder(dishId, orderId, quantity);
 
        verify(orderPerDishRepository).save(any(OrderPerDish.class));
        verify(ordersRepository).save(mockOrder);
        assertEquals(20.0f, mockOrder.getOrder_total());
    }
 
    @Test
    void addDishToOrder_OrderNotFound() {
        int dishId = 1;
        int orderId = 10;
        int quantity = 2;
 
        when(ordersRepository.findById(orderId)).thenReturn(Optional.empty());
 
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> orderService.addDishToOrder(dishId, orderId, quantity));
 
        assertEquals("Order not found with ID: 10", exception.getMessage());
    }
 
    @Test
    void removeOrder_Success() {
        int orderId = 10;
        Orders mockOrder = new Orders();
        mockOrder.setOrder_id(orderId);
 
        when(ordersRepository.findById(orderId)).thenReturn(Optional.of(mockOrder));
 
        orderService.removeOrder(orderId);
 
        verify(orderPerDishRepository).deleteByOrder_id(orderId);
        verify(ordersRepository).deleteById(orderId);
    } */
}
