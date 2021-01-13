package Franciscobusleiman.recipes.recipes.controllers;

import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String getRecipe(@PathVariable String id, Model model){


        model.addAttribute("recipe", recipeService.findCommandById(id));


        return "recipe/show";
    }

    @RequestMapping("recipe/newRecipe")
    public String newRecipe(Model model){
        RecipeCommand recipeCommand = new RecipeCommand();
        model.addAttribute("recipe", recipeCommand);

        return "recipe/form";
    }

    @PostMapping("saveRecipe")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand recipeCommand){


   RecipeCommand recipeCommand1 = recipeService.save(recipeCommand);

   return "redirect:/recipe/" + recipeCommand1.getId() + "/show/";

    }

        @RequestMapping("recipe/{id}/update")
        public String updateRecipe(@PathVariable String id, Model model){

            model.addAttribute("recipe", recipeService.findCommandById(id));
            return "recipe/form";
        }

        @RequestMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id){

        recipeService.deleteById(id);
        return "redirect:/index";
        }

    }

