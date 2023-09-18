package com.mapmyfood.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mapmyfood.model.Payment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PaymentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public Payment getPaymentById(Long id) {
        return entityManager.find(Payment.class, id);
    }

    @Transactional
    public Payment updatePayment(Payment payment) {
        return entityManager.merge(payment);
    }

    @Transactional(readOnly = true)
    public List<Payment> getPaymentsByOrderId(Long orderId) {
		return entityManager.createQuery("SELECT p FROM Payment p WHERE p.orderId = :orderId", Payment.class)
				.setParameter("orderId", orderId).getResultList();

    }

    @Transactional
    public Payment processPayment(Payment payment) {
        entityManager.persist(payment);
        return payment;
    }
}
