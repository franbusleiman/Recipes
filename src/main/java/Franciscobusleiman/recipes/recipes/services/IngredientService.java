package Franciscobusleiman.recipes.recipes.services;

import Franciscobusleiman.recipes.recipes.commands.IngredientCommand;
import org.springframework.stereotype.Service;

@Service
public interface IngredientService {
    public IngredientCommand findRecipeAndIngredientById(Long recipeId, Long ingredeintId);
}
