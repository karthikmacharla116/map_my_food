package com.mapmyfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapmyfood.dto.FoodItemDTO;
import com.mapmyfood.factory.FoodItemFactory;
import com.mapmyfood.model.FoodItem;
import com.mapmyfood.service.FoodItemService;

@RestController
@RequestMapping("/fooditems")
public class FoodItemController {
    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/category/{category}")
    public ResponseEntity<List<FoodItem>> getFoodItemsByCategory(@PathVariable String category) {
        List<FoodItem> foodItems = foodItemService.getFoodItemsByCategory(category);
        return ResponseEntity.ok(foodItems);
    }

    @PostMapping("/add")
    public ResponseEntity<FoodItem> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItem foodItem = FoodItemFactory.createFoodItemFromDTO(foodItemDTO);
        FoodItem savedFoodItem = foodItemService.addFoodItem(foodItem);
        return ResponseEntity.ok(savedFoodItem);
    }
}
