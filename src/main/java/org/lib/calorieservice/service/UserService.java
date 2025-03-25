package org.lib.calorieservice.service;

import lombok.RequiredArgsConstructor;
import org.lib.calorieservice.dto.MealDTO;
import org.lib.calorieservice.entity.Meal;
import org.lib.calorieservice.repository.DishRepository;
import org.lib.calorieservice.repository.MealRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final DishRepository dishRepository;
    private final MealRepository mealRepository;

    public Meal addMeal(MealDTO mealDTO) {
        if(mealDTO == null){
            throw new IllegalArgumentException("Прием пищи не может быть пустым");
        }
        Meal meal = new Meal();
        meal.setDishes(mealDTO.getDishes());
        return mealRepository.save(meal);
    }
}
