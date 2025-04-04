package org.lib.calorieservice.api;

import lombok.RequiredArgsConstructor;
import org.lib.calorieservice.dto.MealDTO;
import org.lib.calorieservice.entity.Meal;
import org.lib.calorieservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping("add_meal")
    public ResponseEntity<Meal> addMeal(@RequestBody MealDTO mealDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.addMeal(mealDTO));
    }
}
