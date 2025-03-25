package org.lib.calorieservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.lib.calorieservice.entity.Dish;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MealDTO {
    private List<Dish> dishes = new ArrayList<>();
}
