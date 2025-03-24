package org.lib.calorieservice.service;

import lombok.RequiredArgsConstructor;
import org.lib.calorieservice.repository.FoodIntakeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final FoodIntakeRepository foodIntakeRepository;

    public void summCalories(){

    }

}
