package org.lib.calorieservice.api;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.lib.calorieservice.dto.MealDTO;
import org.lib.calorieservice.dto.SumReportDTO;
import org.lib.calorieservice.entity.Meal;
import org.lib.calorieservice.service.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final MealService mealService;

    @GetMapping("/history")
    public void history(){


    }

    @PostMapping("sum_calories")
    public ResponseEntity<Double> sumCalories(@RequestBody SumReportDTO sumReportDTO) {
        try{
            List<Meal> mealList = mealService.getMealsForUser(sumReportDTO);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(mealService.calculateTotalCalories(mealList));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/check/{userId}")
    public ResponseEntity<Double> check(@PathVariable Long userId) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mealService.checkDailyCalories(userId));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
