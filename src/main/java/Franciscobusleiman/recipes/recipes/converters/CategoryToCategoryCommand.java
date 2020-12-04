package Franciscobusleiman.recipes.recipes.converters;

import Franciscobusleiman.recipes.recipes.commands.CategoryCommand;
import Franciscobusleiman.recipes.recipes.domain.Category;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import com.sun.istack.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public CategoryToCategoryCommand(RecipeToRecipeCommand recipeToRecipeCommand){
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Nullable
    @Override
    public CategoryCommand convert(Category category) {
        if (category == null) {
            return null;
        }

        CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setCategoryName(category.getCategoryName());
        categoryCommand.setId(category.getId());

        for(Recipe recipe: category.getRecipes()){
            categoryCommand.getRecipes().add(recipeToRecipeCommand.convert(recipe));
        }
        return categoryCommand;
    }
}
