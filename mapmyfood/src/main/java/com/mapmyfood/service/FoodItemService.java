package com.mapmyfood.service;

import com.mapmyfood.model.FoodItem;
import com.mapmyfood.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;

    @Transactional(readOnly = true)
    public List<FoodItem> getFoodItemsByCategory(String category) {
        return foodItemRepository.getFoodItemsByCategory(category);
    }

    @Transactional
    public FoodItem addFoodItem(FoodItem foodItem) {
        return foodItemRepository.addFoodItem(foodItem);
    }

    // Add more methods for updating and deleting food items as needed
}
