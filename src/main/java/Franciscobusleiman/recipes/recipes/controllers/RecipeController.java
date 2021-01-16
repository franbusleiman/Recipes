package Franciscobusleiman.recipes.recipes.controllers;

import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.exceptions.NotFoundException;
import Franciscobusleiman.recipes.recipes.exceptions.NumberFormatsException;
import Franciscobusleiman.recipes.recipes.services.RecipeService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String getRecipe(@PathVariable String id, Model model){

if(! NumberUtils.isCreatable(id)){
    throw new NumberFormatsException("La cadena de texto: '" + id + "' no es un número (ID)");
}
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));


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

            if(! NumberUtils.isCreatable(id)){
                throw new NumberFormatsException("La cadena de texto: '" + id + "' no es un número (ID)");
            }

            model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
            return "recipe/form";
        }

        @RequestMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id){

            if(! NumberUtils.isCreatable(id)){
                throw new NumberFormatsException("La cadena de texto: '" + id + "' no es un número (ID)");
            }

        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/index";
        }


    }

