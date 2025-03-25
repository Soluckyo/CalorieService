package org.lib.calorieservice.repository;

import org.lib.calorieservice.entity.Meal;
import org.lib.calorieservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findMealsByCreatedAtBetweenAndUserContaining(LocalDateTime createdAtAfter, LocalDateTime createdAtBefore, User user);
}
