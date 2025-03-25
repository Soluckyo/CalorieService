package org.lib.calorieservice.api;

import lombok.RequiredArgsConstructor;
import org.lib.calorieservice.entity.Meal;
import org.lib.calorieservice.service.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final MealService mealService;

    @GetMapping("/history")
    public void history(){

    }

    @PostMapping("sum_calories")
    public ResponseEntity<Double> sumCalories(@RequestBody Long mealId) {
        return null;
    }

    @PostMapping("/check")
    public void check(){

    }
}
