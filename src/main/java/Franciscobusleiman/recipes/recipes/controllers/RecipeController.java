package Franciscobusleiman.recipes.recipes.controllers;

import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @RequestMapping("/show/{id}")
    public String getRecipe(@PathVariable String id, Model model){


        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));


        return "show.html";
    }

    @RequestMapping("newRecipe")
    public String newRecipe(Model model){
        RecipeCommand recipeCommand = new RecipeCommand();
        model.addAttribute("recipe", recipeCommand);

        return "form.html";
    }

    @RequestMapping("saveRecipe")
    public String saveRecipe(@ModelAttribute RecipeCommand recipeCommand){


   RecipeCommand recipeCommand1= recipeService.save(recipeCommand);

   return "redirect:/show/" + recipeCommand1.getId();

    }
}
