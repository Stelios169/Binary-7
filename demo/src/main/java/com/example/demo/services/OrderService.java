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

import com.example.demo.models.DOid;
import com.example.demo.models.Dish;
import com.example.demo.models.OrderPerDish;
import com.example.demo.models.Orders;
import com.example.demo.models.RTable;
import com.example.demo.models.TId;
import com.example.demo.repositories.DishRepository;
import com.example.demo.repositories.OrderPerDishRepository;
import com.example.demo.repositories.OrdersRepository;
import com.example.demo.repositories.RTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final OrderPerDishRepository orderPerDishRepository;
    private final DishRepository dishRepository;
    private final RTableRepository rTableRepository;

    @Autowired
    public OrderService(OrdersRepository ordersRepository,
            OrderPerDishRepository orderPerDishRepository,
            DishRepository dishRepository,
            RTableRepository rTableRepository) {
        this.ordersRepository = ordersRepository;
        this.orderPerDishRepository = orderPerDishRepository;
        this.dishRepository = dishRepository;
        this.rTableRepository = rTableRepository;
    }

    public Orders createOrder(int tableId, int restaurantId) {
        Optional<RTable> optionalRTable = rTableRepository.findById(new TId(tableId,
                restaurantId));
        if (optionalRTable.isEmpty()) {
            throw new RuntimeException(
                    "Table not found with tableId: " + tableId + " and restaurantId: " +
                            restaurantId);
        }

        Orders order = new Orders(0, 100.50f, true, LocalDateTime.now());
        order.setTable(optionalRTable.get());
        order.setOrder_total((float) 0.0); // Αρχική τιμή
        order.setOrder_status(true); // Ενεργή παραγγελία
        order.setOrder_datetime(LocalDateTime.now());

        return ordersRepository.save(order);
}

    public void addDishToOrder( int dishId, int orderId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }
        
        Optional<Orders> optionalOrder = ordersRepository.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }

        Optional<Dish> optionalDish = dishRepository.findById(dishId);
        if (optionalDish.isEmpty()) {
            throw new RuntimeException("Dish not found with ID: " + dishId);
        }

        Dish dish = optionalDish.get();
        if (!dish.isDish_availability()) {
        throw new RuntimeException("The dish is currently unavailable.");
        }

    try {    
        Orders order = optionalOrder.get();
        float dishTotal = (float) (dish.getDish_price() * quantity);
        DOid compositeKey = new DOid(orderId, dishId);
        OrderPerDish orderPerDish = new OrderPerDish();
        orderPerDish.setId(compositeKey);
        orderPerDish.setDish(dish);
        orderPerDish.setOrder(order);
        orderPerDish.setOrderPerDish_quantity(quantity);
        orderPerDishRepository.save(orderPerDish);

        order.setOrder_total(order.getOrder_total() + dishTotal);
        ordersRepository.save(order);
    } catch (Exception e) {
         // Logging
         e.printStackTrace();
         System.err.println("Error while adding dish to order: " + e.getMessage());
         throw new RuntimeException("Failed to add dish to order. Please try again.", e);
    }
}

    public void removeOrder(Integer orderId) {
        Optional<Orders> optionalOrder = ordersRepository.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }

    try {
        orderPerDishRepository.deleteByOrder_id(orderId);

        ordersRepository.deleteById(orderId);
    } catch (Exception e) {
          // Logging
          System.err.println("Error while removing order: " + e.getMessage());
          throw new RuntimeException("Failed to remove order. Please try again.");
    }
    }
}
