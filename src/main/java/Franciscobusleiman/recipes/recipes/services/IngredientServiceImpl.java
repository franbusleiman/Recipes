package Franciscobusleiman.recipes.recipes.services;

import Franciscobusleiman.recipes.recipes.commands.IngredientCommand;
import Franciscobusleiman.recipes.recipes.converters.IngredientToIngredientCommand;
import Franciscobusleiman.recipes.recipes.domain.Ingredient;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{

    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientToIngredientCommand ingredientToIngredientCommand){
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Override
    public IngredientCommand findRecipeAndIngredientById(Long recipeId, Long ingredeintId) {

        Optional<Recipe> recipe = recipeRepository.findById(recipeId);

        if(! recipe.isPresent()){
            log.debug("El recipe con id " + recipeId + " no fue encontrado");
        }
            Recipe recipe1 = recipe.get();

            Optional<IngredientCommand> ingredientCommand = recipe1.getIngredients().stream().
                                                                                     filter(ingredient -> ingredient.getId().equals(ingredeintId)).
                                                                                     map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();
            if(!ingredientCommand.isPresent()){
                log.debug("Ingrediente con id " + ingredeintId + " no encontrado");
            }

             return ingredientCommand.get();




    }
}
