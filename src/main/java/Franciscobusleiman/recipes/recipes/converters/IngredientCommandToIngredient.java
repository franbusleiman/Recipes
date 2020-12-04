package Franciscobusleiman.recipes.recipes.converters;

import Franciscobusleiman.recipes.recipes.commands.IngredientCommand;
import Franciscobusleiman.recipes.recipes.domain.Ingredient;
import com.sun.istack.Nullable;
import org.springframework.core.convert.converter.Converter;

public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

    public IngredientCommandToIngredient(RecipeCommandToRecipe recipeCommandToRecipe, UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure){
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.unitOfMeasureCommandToUnitOfMeasure = unitOfMeasureCommandToUnitOfMeasure;
    }
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {
        if(ingredientCommand == null){
        return null;
        }
        Ingredient ingredient = new Ingredient();

        ingredient.setDescription(ingredientCommand.getDescription());
ingredient.setAmount(ingredientCommand.getAmount());
ingredient.setId(ingredientCommand.getId());
ingredient.setRecipe(recipeCommandToRecipe.convert(ingredientCommand.getRecipe()));
ingredient.setUnitOfMeasure(unitOfMeasureCommandToUnitOfMeasure.convert(ingredientCommand.getUnitOfMeasure()));

return ingredient;
    }
}
