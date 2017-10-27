package com.yves.springrecipeapp.controllers;

import com.yves.springrecipeapp.commands.RecipeCommand;
import com.yves.springrecipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.PastOrPresent;

@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @RequestMapping("/recipe/{id}/update")
    public String update(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(new Long(id)));
        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show/";
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/delete")
    public String deleteById(@PathVariable String id) {
        recipeService.deleteById(new Long(id));

        return "redirect:/";
    }
}
