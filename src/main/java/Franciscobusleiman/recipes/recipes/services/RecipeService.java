package Franciscobusleiman.recipes.recipes.services;

import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    public Set<Recipe> getRecipes();

    public void deleteById(Long id);

    public Recipe findById(Long id);

    public RecipeCommand findCommandById(Long id);

    public RecipeCommand save(RecipeCommand recipeCommand);



}
