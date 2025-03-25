package org.lib.calorieservice.repository;

import org.lib.calorieservice.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
