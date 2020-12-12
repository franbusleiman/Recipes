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
    public void deleteIngredient(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(! recipeOptional.isPresent()){
            log.debug("El recipe no fue encontrado");
        }
        Recipe recipe = recipeOptional.get();

        Optional<Ingredient> ingredientOptional = recipe.getIngredients().stream().filter(ingredient -> ingredient.getId().equals(ingredientId)).findFirst();

        if(ingredientOptional.isPresent()){
            Ingredient ingredient = ingredientOptional.get();
           ingredient.setRecipe(null);
            recipe.getIngredients().remove(ingredientOptional.get());
            recipeRepository.save(recipe);
        }

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
                ingredientOk.setRecipe(recipeOk);
            } else {
                Ingredient ingredient = ingredientCommandToIngredient.convert(ingredientCommand);
                ingredient.setRecipe(recipeOk);
                recipeOk.getIngredients().add(ingredient);

            }


           Recipe recipe1 = recipeRepository.save(recipeOk);

            Optional<Ingredient> ingredient1 = recipe1.getIngredients().stream().filter(ingredient -> ingredient.getId().equals(ingredientCommand.getId())).findFirst();


            if(!ingredient1.isPresent()){

                ingredient1 = recipe1.getIngredients().stream().filter(ingredient -> ingredient.getDescription().equals(ingredientCommand.getDescription())).filter(ingredient -> ingredient.getAmount().equals(ingredientCommand.getAmount())).findFirst();
            }


            return ingredientToIngredientCommand.convert(ingredient1.get());
        }
    }
}
