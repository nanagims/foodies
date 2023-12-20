package com.nanagims.foodies.repository;

import com.nanagims.foodies.domain.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, String> {
}
