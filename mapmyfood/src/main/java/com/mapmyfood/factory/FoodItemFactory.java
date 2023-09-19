package com.mapmyfood.factory;

import com.mapmyfood.dto.FoodItemDTO;
import com.mapmyfood.model.FoodItem;

public class FoodItemFactory {
    public static FoodItem createFoodItemFromDTO(FoodItemDTO dto) {
        FoodItem foodItem = new FoodItem();
        foodItem.setName(dto.getName());
        foodItem.setCategory(dto.getCategory());
        foodItem.setPrice(dto.getPrice());
        return foodItem;
    }
}
