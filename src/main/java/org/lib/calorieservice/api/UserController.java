package org.lib.calorieservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class UserController {

    @GetMapping("/sum_calories")
    public void sumCalories(){

    }

    @PostMapping("/check")
    public void check(){

    }

    @GetMapping("/history")
    public void history(){

    }
}
