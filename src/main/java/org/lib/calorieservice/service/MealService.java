package org.lib.calorieservice.service;

import lombok.RequiredArgsConstructor;
import org.lib.calorieservice.entity.Day;
import org.lib.calorieservice.entity.Dish;
import org.lib.calorieservice.entity.Meal;
import org.lib.calorieservice.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepository mealRepository;

    private double sumCalories(Long id) {
        Meal meal = mealRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Meal not found"));
        return meal.getDishes().stream().mapToDouble(Dish::getCalories).sum();
    }

    public double calories(Day day) {
        
    }


}
