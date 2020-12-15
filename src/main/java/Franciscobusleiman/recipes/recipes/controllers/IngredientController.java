package Franciscobusleiman.recipes.recipes.controllers;

import Franciscobusleiman.recipes.recipes.commands.IngredientCommand;
import Franciscobusleiman.recipes.recipes.commands.UnitOfMeasureCommand;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.services.IngredientService;
import Franciscobusleiman.recipes.recipes.services.RecipeService;
import Franciscobusleiman.recipes.recipes.services.UnitOfMeasureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService){
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @RequestMapping("recipe/{id}/ingredients")
    public String getIngredients(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/ingredient/ingredients";
    }

    @RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}/showIngredient")
    public String getIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model){

        model.addAttribute("ingredient", ingredientService.findRecipeAndIngredientById(Long.valueOf(recipeId), Long.valueOf(ingredientId)));
        return "recipe/ingredient/showIngredient";
    }

    @RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}/updateIngredient")
    public String updateIngredientes(@PathVariable String recipeId, @PathVariable String ingredientId, Model model){

        model.addAttribute("ingredient", ingredientService.findRecipeAndIngredientById(Long.valueOf(recipeId), Long.valueOf(ingredientId)));
        model.addAttribute("uoms", unitOfMeasureService.getUoms() );

        return "recipe/ingredient/ingredientForm";
    }

    @RequestMapping("/SaveIngredient")
    public String updateIngredient(@ModelAttribute IngredientCommand ingredient, Model model){


model.addAttribute("ingredient", ingredientService.SaveOrUpdateIngredient(ingredient));

         return "recipe/ingredient/showIngredient";
    }

    @RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}/deleteIngredient")
    public String deleteIngredient(@PathVariable String recipeId, @PathVariable String ingredientId){

        ingredientService.deleteIngredient(Long.valueOf(recipeId), Long.valueOf(ingredientId));

        return "redirect:/index";
    }

    @RequestMapping("recipe/{recipeId}/newIngredient")
    public String newIngredient(@PathVariable String recipeId, Model model){

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setUnitOfMeasure(new UnitOfMeasureCommand());
        ingredientCommand.setRecipeId(Long.valueOf(recipeId));
        model.addAttribute("ingredient", ingredientCommand);
        model.addAttribute("uoms", unitOfMeasureService.getUoms());
        return "recipe/ingredient/ingredientForm";
    }

}
