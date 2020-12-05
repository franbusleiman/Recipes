package Franciscobusleiman.recipes.recipes.services;


import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.converters.RecipeCommandToRecipe;
import Franciscobusleiman.recipes.recipes.converters.RecipeToRecipeCommand;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.repositories.RecipeRepository;
import com.sun.istack.Nullable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
    private final RecipeCommandToRecipe recipeCommandToRecipe;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeToRecipeCommand recipeToRecipeCommand, RecipeCommandToRecipe recipeCommandToRecipe){
        this.recipeRepository = recipeRepository;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
        this.recipeCommandToRecipe = recipeCommandToRecipe;

    }

    @Override
    public Set<Recipe> getRecipes() {

        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);

        return recipes;
    }

    @Override
    public void deleteById(Long id) {

        recipeRepository.deleteById(id);

    }
    @Nullable
    @Override
    public Recipe findById(Long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(!recipeOptional.isPresent()){
            return null;
        }
        return recipeOptional.get();
    }

    @Override
    public RecipeCommand findCommandById(Long id) {

    RecipeCommand recipeCommand = recipeToRecipeCommand.convert(findById(id));
    return recipeCommand;
    }

    @Override
    public RecipeCommand save(RecipeCommand recipeCommand) {
        
   if(recipeCommand == null){
      return null;
     }

        Recipe recipeConvertido = recipeCommandToRecipe.convert(recipeCommand);
        Recipe recipeGuardado = recipeRepository.save(recipeConvertido);
        RecipeCommand recipeCommand1 = recipeToRecipeCommand.convert(recipeGuardado);

        return recipeCommand1;
    }
}
