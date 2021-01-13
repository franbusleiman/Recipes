package Franciscobusleiman.recipes.recipes.services;

import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    public Set<Recipe> getRecipes();

    public void deleteById(String id);

    public Recipe findById(String id);

    public RecipeCommand findCommandById(String id);

    public RecipeCommand save(RecipeCommand recipeCommand);



}
