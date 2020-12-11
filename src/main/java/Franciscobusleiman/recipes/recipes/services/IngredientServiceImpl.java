package Franciscobusleiman.recipes.recipes.services;

import Franciscobusleiman.recipes.recipes.commands.IngredientCommand;
import Franciscobusleiman.recipes.recipes.converters.IngredientCommandToIngredient;
import Franciscobusleiman.recipes.recipes.converters.IngredientToIngredientCommand;
import Franciscobusleiman.recipes.recipes.domain.Ingredient;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.repositories.RecipeRepository;
import Franciscobusleiman.recipes.recipes.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientToIngredientCommand ingredientToIngredientCommand, IngredientCommandToIngredient ingredientCommandToIngredient, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public IngredientCommand findRecipeAndIngredientById(Long recipeId, Long ingredeintId) {

        Optional<Recipe> recipe = recipeRepository.findById(recipeId);

        if (!recipe.isPresent()) {
            log.debug("El recipe con id " + recipeId + " no fue encontrado");
        }
        Recipe recipe1 = recipe.get();

        Optional<IngredientCommand> ingredientCommand = recipe1.getIngredients().stream().
                filter(ingredient -> ingredient.getId().equals(ingredeintId)).
                map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();
        if (!ingredientCommand.isPresent()) {
            log.debug("Ingrediente con id " + ingredeintId + " no encontrado");
        }

        return ingredientCommand.get();
    }

    @Override
    public IngredientCommand SaveOrUpdateIngredient(IngredientCommand ingredientCommand) {

        Optional<Recipe> recipe = recipeRepository.findById(ingredientCommand.getRecipeId());

        if (!recipe.isPresent()) {
            return new IngredientCommand();
        } else {
            Recipe recipeOk = recipe.get();

            Optional<Ingredient> ingredientOptional = recipeOk.getIngredients().stream().filter(ingredient1 -> ingredient1.getId().equals(ingredientCommand.getId())).findFirst();
            if (ingredientOptional.isPresent()) {

                Ingredient ingredientOk = ingredientOptional.get();

                ingredientOk.setAmount(ingredientCommand.getAmount());
                ingredientOk.setDescription(ingredientCommand.getDescription());
                ingredientOk.setUnitOfMeasure(unitOfMeasureRepository.findById(ingredientCommand.getUnitOfMeasure().getId()).get());
            } else {
                recipeOk.getIngredients().add(ingredientCommandToIngredient.convert(ingredientCommand));
            }


            recipeRepository.save(recipeOk);

            return ingredientToIngredientCommand.convert(recipeOk.getIngredients().stream().filter(ingredient -> ingredient.getId().equals(ingredientCommand.getId())).findFirst().get());
        }
    }
}
