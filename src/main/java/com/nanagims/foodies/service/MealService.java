package com.nanagims.foodies.service;

import com.nanagims.foodies.domain.Meal;
import com.nanagims.foodies.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MealService {

    private final MealRepository mealRepository;

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }
}
