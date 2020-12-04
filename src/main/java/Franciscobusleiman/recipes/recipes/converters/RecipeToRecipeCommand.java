package Franciscobusleiman.recipes.recipes.converters;

import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.domain.*;
import com.sun.istack.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final NotesToNotesCommand notesToNotesCommand;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final CategoryToCategoryCommand categoryToCategoryCommand;


    public RecipeToRecipeCommand(NotesToNotesCommand notesToNotesCommand, IngredientToIngredientCommand ingredientToIngredientCommand, CategoryToCategoryCommand categoryToCategoryCommand) {
        this.notesToNotesCommand = notesToNotesCommand;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.categoryToCategoryCommand = categoryToCategoryCommand;

    }

    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        RecipeCommand recipeCommand = new RecipeCommand();

        recipeCommand.setId(recipe.getId());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setUrl(recipe.getUrl());
        recipeCommand.setDirections(recipe.getDirections());
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setImage(recipe.getImage());
        recipeCommand.setNotes(notesToNotesCommand.convert(recipe.getNotes()));


        for (Category category : recipe.getCategories()) {
            recipeCommand.getCategories().add(categoryToCategoryCommand.convert(category));
        }
        for (Ingredient ingredient : recipe.getIngredients()) {
            recipeCommand.getIngredients().add(ingredientToIngredientCommand.convert(ingredient));
        }

        return recipeCommand;
    }
}