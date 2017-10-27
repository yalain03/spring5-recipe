package com.yves.springrecipeapp.services;

import com.yves.springrecipeapp.commands.IngredientCommand;
import com.yves.springrecipeapp.domain.Ingredient;
import org.springframework.stereotype.Service;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long aLong, Long aLong1);

    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
