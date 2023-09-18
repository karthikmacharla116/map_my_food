package com.mapmyfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapmyfood.dto.OrderDTO;
import com.mapmyfood.factory.OrderFactory;
import com.mapmyfood.model.Order;
import com.mapmyfood.service.OrderService;
import com.mapmyfood.util.MessageUtil;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private MessageUtil messageUtil;

    @PostMapping("/place-order")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDTO orderDTO) {
        Order order = OrderFactory.createOrderFromDTO(orderDTO);
        Order placedOrder = orderService.placeOrder(order);
        messageUtil.triggerOrderPlacedMessage();
        
        return ResponseEntity.ok(placedOrder);
    }
}
