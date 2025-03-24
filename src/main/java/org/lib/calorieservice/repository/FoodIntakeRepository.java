package org.lib.calorieservice.repository;

import org.lib.calorieservice.entity.FoodIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodIntakeRepository extends JpaRepository<FoodIntake, Long> {
}
