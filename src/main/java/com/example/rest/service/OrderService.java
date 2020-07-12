package com.example.rest.service;


import com.example.rest.model.Order;
import com.example.rest.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addNewOrderOrChange(Order newOrder){
        orderRepository.save(newOrder);
    }

    public void delOrder(Long orderId){
        orderRepository.deleteById(orderId);
    }

    public Order getOneOrderById(Long orderId) {
            Optional<Order> order = orderRepository.findById(orderId);
        return order.get();
    }
}
