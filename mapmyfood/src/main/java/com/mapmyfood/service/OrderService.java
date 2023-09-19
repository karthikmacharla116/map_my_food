package com.mapmyfood.service;

import com.mapmyfood.model.Order;
import com.mapmyfood.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order placeOrder(Order order) {
        return orderRepository.placeOrder(order);
    }

    @Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    @Transactional
    public Order updateOrder(Order order) {
        return orderRepository.updateOrder(order);
    }

    // Add more methods for retrieving and managing orders as needed
}
