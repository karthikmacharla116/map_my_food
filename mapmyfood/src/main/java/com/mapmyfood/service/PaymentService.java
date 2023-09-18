package com.mapmyfood.service;

import com.mapmyfood.model.Payment;
import com.mapmyfood.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public Payment processPayment(Payment payment) {
        return paymentRepository.processPayment(payment);
    }

    @Transactional(readOnly = true)
    public Payment getPaymentById(Long id) {
        return paymentRepository.getPaymentById(id);
    }

    @Transactional
    public Payment updatePayment(Payment payment) {
        return paymentRepository.updatePayment(payment);
    }

    // Add more methods for retrieving and managing payments as needed
}
