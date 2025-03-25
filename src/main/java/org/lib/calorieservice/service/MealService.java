package org.lib.calorieservice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.lib.calorieservice.dto.SumReportDTO;
import org.lib.calorieservice.entity.Dish;
import org.lib.calorieservice.entity.Meal;
import org.lib.calorieservice.entity.User;
import org.lib.calorieservice.repository.MealRepository;
import org.lib.calorieservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepository mealRepository;
    private final UserRepository userRepository;

    public List<Meal> getMealsForUser(SumReportDTO sumReportDTO) {
        User user = findUserById(sumReportDTO.getUserId());
        LocalDateTime startDate = sumReportDTO.getDate().toLocalDate().atStartOfDay();
        LocalDateTime endDate = startDate.plusDays(1);
        return mealRepository.findMealsByCreatedAtBetweenAndUserContaining(startDate, endDate, user);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " not found"));
    }
    public double calculateTotalCalories(List<Meal> meals) {
        if (meals == null || meals.isEmpty()) {
            return 0;
        }
        return meals.stream()
                .flatMap(meal -> meal.getDishes().stream())
                .mapToDouble(Dish::getCalories)
                .sum();
    }

    public double checkDailyCalories(Long userId) {
        LocalDateTime now = LocalDateTime.now();
        SumReportDTO sumReportDTO = new SumReportDTO();
        sumReportDTO.setDate(now);
        sumReportDTO.setUserId(userId);
        List<Meal> meals = getMealsForUser(sumReportDTO);
        return calculateTotalCalories(meals);
    }


}
