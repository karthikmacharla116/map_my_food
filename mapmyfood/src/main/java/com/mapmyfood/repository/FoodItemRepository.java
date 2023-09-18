package com.mapmyfood.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mapmyfood.model.FoodItem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class FoodItemRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<FoodItem> getFoodItemsByCategory(String category) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FoodItem> query = builder.createQuery(FoodItem.class);
        Root<FoodItem> root = query.from(FoodItem.class);
        query.select(root).where(builder.equal(root.get("category"), category));
        return entityManager.createQuery(query).getResultList();
    }

    @Transactional
    public FoodItem addFoodItem(FoodItem foodItem) {
        entityManager.persist(foodItem);
        return foodItem;
    }

    // Add more methods for updating and deleting food items as needed
}
