package Franciscobusleiman.recipes.recipes.controllers;

import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.services.IngredientService;
import Franciscobusleiman.recipes.recipes.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService){
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @RequestMapping("/show/ingredients/{id}")
    public String getIngredients(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "ingredients.html";
    }

    @RequestMapping("/show/ingredients/showIngredient/{recipeId}/{ingredientId}")
    public String getIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model){

        model.addAttribute("ingredient", ingredientService.findRecipeAndIngredientById(Long.valueOf(recipeId), Long.valueOf(ingredientId)));
        return "showIngredient.html";
    }



}
