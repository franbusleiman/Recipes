package Franciscobusleiman.recipes.recipes.services;

import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    public Set<Recipe> getRecipes();

    public void deleteById(Long id);

    public Recipe findById(Long id);

    public RecipeCommand findCommandById(Long id);

    public RecipeCommand save(RecipeCommand recipeCommand);



}
