package com.yves.springrecipeapp.controllers;


import com.yves.springrecipeapp.domain.Category;
import com.yves.springrecipeapp.domain.UnitOfMeasure;
import com.yves.springrecipeapp.repositories.CategoryRepository;
import com.yves.springrecipeapp.repositories.UnitOfMeasureRepository;
import com.yves.springrecipeapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
