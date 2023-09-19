package com.mapmyfood.factory;

import com.mapmyfood.dto.OrderDTO;
import com.mapmyfood.model.Order;

public class OrderFactory {
    public static Order createOrderFromDTO(OrderDTO dto) {
        Order order = new Order();
        order.setFoodItemId(dto.getFoodItemId());
        order.setQuantity(dto.getQuantity());
        order.setCustomerName(dto.getCustomerName());
        order.setDeliveryAddress(dto.getDeliveryAddress());
        // You can set other properties as needed
        return order;
    }
    
}
