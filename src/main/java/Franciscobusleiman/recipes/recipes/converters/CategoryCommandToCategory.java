package Franciscobusleiman.recipes.recipes.converters;

import Franciscobusleiman.recipes.recipes.commands.CategoryCommand;
import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.domain.Category;
import com.sun.istack.Nullable;
import org.springframework.core.convert.converter.Converter;

public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

private final RecipeCommandToRecipe recipeCommandToRecipe;

public CategoryCommandToCategory(RecipeCommandToRecipe recipeCommandToRecipe){
    this.recipeCommandToRecipe = recipeCommandToRecipe;
}

    @Nullable
    @Override
    public Category convert(CategoryCommand categoryCommand) {
        if(categoryCommand == null){
            return null;
        }
       Category category = new Category();

        category.setCategoryName(category.getCategoryName());
        category.setId(categoryCommand.getId());

        for(RecipeCommand recipe: categoryCommand.getRecipes()){
            category.getRecipes().add(recipeCommandToRecipe.convert(recipe));
        }


        return category;
    }
}
