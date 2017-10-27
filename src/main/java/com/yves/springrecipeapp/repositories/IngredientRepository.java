package com.yves.springrecipeapp.repositories;

import com.yves.springrecipeapp.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
