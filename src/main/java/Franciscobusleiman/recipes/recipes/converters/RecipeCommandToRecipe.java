package Franciscobusleiman.recipes.recipes.converters;

import Franciscobusleiman.recipes.recipes.commands.CategoryCommand;
import Franciscobusleiman.recipes.recipes.commands.IngredientCommand;
import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import com.sun.istack.Nullable;
import org.springframework.core.convert.converter.Converter;

public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {


    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final CategoryCommandToCategory categoryCommandToCategory;
    private final NotesCommandToNotes notesCommandToNotes;

    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientCommandToIngredient, CategoryCommandToCategory categoryCommandToCategory, NotesCommandToNotes notesCommandToNotes){
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.categoryCommandToCategory = categoryCommandToCategory;
        this.notesCommandToNotes = notesCommandToNotes;
    }

    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {

        if(recipeCommand == null) {
            return null;
        }
        Recipe recipe = new Recipe();

        recipe.setId(recipeCommand.getId());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setDirections(recipeCommand.getDescription());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setServings(recipeCommand.getServings());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setImage(recipeCommand.getImage());
        recipe.setSource(recipeCommand.getSource());
        recipe.setNotes(notesCommandToNotes.convert(recipeCommand.getNotes()));

        for(CategoryCommand category: recipeCommand.getCategories()){
            recipe.getCategories().add(categoryCommandToCategory.convert(category));
        }
        for(IngredientCommand ingredient: recipeCommand.getIngredients()){
            recipe.getIngredients().add(ingredientCommandToIngredient.convert(ingredient));
        }


        return recipe;


    }
}
