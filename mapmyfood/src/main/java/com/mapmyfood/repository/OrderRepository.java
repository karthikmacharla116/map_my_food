package com.mapmyfood.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mapmyfood.model.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class OrderRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public Order getOrderById(Long id) {
		return entityManager.find(Order.class, id);
	}

	@Transactional
	public Order updateOrder(Order order) {
		return entityManager.merge(order);
	}

	@Transactional(readOnly = true)
	public List<Order> getOrdersByCustomerName(String customerName) {

		return entityManager.createQuery("SELECT o FROM Order o WHERE o.customerName = :customerName", Order.class)
				.setParameter("customerName", customerName).getResultList();
	}

    @Transactional
    public Order placeOrder(Order order) {
        entityManager.persist(order);
        return order;
    }
}
