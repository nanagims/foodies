package com.nanagims.foodies.service;

import com.nanagims.foodies.domain.Meal;
import com.nanagims.foodies.repository.MealRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MealServiceTest {

    @InjectMocks
    MealService objectToTest;

    @Mock
    MealRepository mealRepository;

    @Test
    void getAllMealsTest() {

        Meal meal1 = mock(Meal.class);
        Meal meal2 = mock(Meal.class);
        when(mealRepository.findAll()).thenReturn(List.of(meal1, meal2));

        assertThat(objectToTest.getAllMeals())
                .containsExactlyInAnyOrder(meal1, meal2);
    }


}