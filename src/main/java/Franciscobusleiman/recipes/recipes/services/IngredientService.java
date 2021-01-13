package Franciscobusleiman.recipes.recipes.services;

import Franciscobusleiman.recipes.recipes.commands.IngredientCommand;
import org.springframework.stereotype.Service;

@Service
public interface IngredientService {

    public IngredientCommand findRecipeAndIngredientById(String recipeId, String ingredeintId);

    public void deleteIngredient(String recipeId, String ingredientId);

    public IngredientCommand SaveOrUpdateIngredient(IngredientCommand ingredientCommand);

}
