package com.example.demo.services;

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
import org.springframework.web.bind.annotation.GetMapping;

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

        Orders order = new Orders(1, 26, true, LocalDateTime.now() );
        order.setTable(optionalRTable.get());
        order.setOrder_total(0.0); // Αρχική τιμή
        order.setOrder_status(true); // Ενεργή παραγγελία
        order.setOrder_datetime(LocalDateTime.now());

        return ordersRepository.save(order);
    }

    public void addDishToOrder(int orderId, int dishId, int quantity) {
        Optional<Orders> optionalOrder = ordersRepository.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }

        Optional<Dish> optionalDish = dishRepository.findById(dishId);
        if (optionalDish.isEmpty()) {
            throw new RuntimeException("Dish not found with ID: " + dishId);
        }

        Orders order = optionalOrder.get();
        Dish dish = optionalDish.get();
        double dishTotal = dish.getDish_price() * quantity;

        OrderPerDish orderPerDish = new OrderPerDish();
        orderPerDish.setDish(dish);
        orderPerDish.setOrder(order);
        orderPerDish.setOrderPerDish_quantity(quantity);
        orderPerDishRepository.save(orderPerDish);

        order.setOrder_total(order.getOrder_total() + dishTotal);
        ordersRepository.save(order);
    }

    public void removeOrder(Integer orderId) {
        Optional<Orders> optionalOrder = ordersRepository.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }

        orderPerDishRepository.deleteByOrder_id(orderId);

        ordersRepository.deleteById(orderId);
    }
}
