package com.mapmyfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapmyfood.dto.PaymentDTO;
import com.mapmyfood.factory.PaymentFactory;
import com.mapmyfood.model.Payment;
import com.mapmyfood.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process-payment")
    public ResponseEntity<Payment> processPayment(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = PaymentFactory.createPaymentFromDTO(paymentDTO);
        Payment processedPayment = paymentService.processPayment(payment);
        return ResponseEntity.ok(processedPayment);
    }
}
