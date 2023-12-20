package com.nanagims.foodies.controller;

import com.nanagims.foodies.domain.Meal;
import com.nanagims.foodies.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/meal")
public class MealController {

    private final MealService mealService;

    @GetMapping(produces = "application/json")
    List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }
}
