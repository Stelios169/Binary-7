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

import com.example.demo.models.Orders;
import com.example.demo.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final OrdersRepository ordersRepository;

    public PaymentService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public float processPayment(int tableId, int restaurantId) {
        // Fetch orders: 0, single or multiple
        List<Orders> multipleOrders = ordersRepository.findAllByTableIdAndRestaurantIdAndOrderStatus(tableId, restaurantId, true);

        float totalAmount = 0;

        if (!multipleOrders.isEmpty()) {

            for (Orders order : multipleOrders) {
                totalAmount += order.getOrder_total();
                order.setOrder_status(false);
                ordersRepository.save(order);
            }
        }

        return totalAmount;
    }
}
