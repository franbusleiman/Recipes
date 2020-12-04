package Franciscobusleiman.recipes.recipes.converters;

import Franciscobusleiman.recipes.recipes.commands.IngredientCommand;
import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.commands.UnitOfMeasureCommand;
import Franciscobusleiman.recipes.recipes.domain.Ingredient;

import com.sun.istack.Nullable;
import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;

public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;
private final RecipeToRecipeCommand recipeToRecipeCommand;

public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand, RecipeToRecipeCommand recipeToRecipeCommand){
    this.recipeToRecipeCommand = recipeToRecipeCommand;
    this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
}

    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if(ingredient == null){
            return null;
        }

        IngredientCommand ingredientCommand = new IngredientCommand();

        ingredientCommand.setId(ingredient.getId());
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setDescription(ingredient.getDescription());
       ingredientCommand.setUnitOfMeasure(unitOfMeasureToUnitOfMeasureCommand.convert(ingredient.getUnitOfMeasure()));
       ingredientCommand.setRecipe(recipeToRecipeCommand.convert(ingredient.getRecipe()));


       return ingredientCommand;

    }
}
