package com.nanagims.foodies.controller;

import com.nanagims.foodies.domain.Meal;
import com.nanagims.foodies.service.MealService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebFluxTest
@SpringJUnitConfig
class MealControllerTest {
    protected WebTestClient webTestClient;
    @MockBean
    MealService mealService;

    @BeforeEach
    public void initWebTestClient() {
        this.webTestClient = WebTestClient.bindToController(new MealController(mealService)).build();
    }

    @Test
    void getAllMealsTest() {

        Meal meal1 = new Meal(UUID.randomUUID().toString());
        Meal meal2 = new Meal(UUID.randomUUID().toString());
        when(mealService.getAllMeals()).thenReturn(List.of(meal1, meal2));

        List<Meal> responseBody = webTestClient
                .get()
                .uri("/meal")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Meal.class)
                .returnResult()
                .getResponseBody();

        assertThat(responseBody)
                .containsExactlyInAnyOrderElementsOf(List.of(meal1, meal2));

    }

}