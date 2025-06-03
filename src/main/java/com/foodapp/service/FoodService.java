package com.foodapp.service;

import com.foodapp.model.Food;
import com.foodapp.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }
    
    public Food getFoodById(Long id) {
        return foodRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Food not found"));
    }
    
    @Transactional
    public Food createFood(Food food) {
        food.getIngredients().forEach(ingredient -> ingredient.setFood(food));
        return foodRepository.save(food);
    }
    
    @Transactional
    public Food updateFood(Long id, Food foodDetails) {
        Food food = getFoodById(id);
        food.setName(foodDetails.getName());
        food.setDescription(foodDetails.getDescription());
        food.setCuisineType(foodDetails.getCuisineType());
        food.setPreparationTime(foodDetails.getPreparationTime());
        food.setDifficultyLevel(foodDetails.getDifficultyLevel());
        food.setCaloriesPerServing(foodDetails.getCaloriesPerServing());
        
        food.getIngredients().clear();
        foodDetails.getIngredients().forEach(ingredient -> {
            ingredient.setFood(food);
            food.getIngredients().add(ingredient);
        });
        
        return foodRepository.save(food);
    }
    
    @Transactional
    public void deleteFood(Long id) {
        Food food = getFoodById(id);
        foodRepository.delete(food);
    }
}