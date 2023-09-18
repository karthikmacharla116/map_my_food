package com.mapmyfood.factory;

import com.mapmyfood.dto.PaymentDTO;
import com.mapmyfood.model.Payment;

public class PaymentFactory {
    public static Payment createPaymentFromDTO(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setOrderId(dto.getOrderId());
        payment.setAmount(dto.getAmount());
        payment.setPaymentMethod(dto.getPaymentMethod());
        // You can set other properties as needed
        return payment;
    }
   
}
