package Franciscobusleiman.recipes.recipes.domain;

import Franciscobusleiman.recipes.recipes.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    Ingredient ingredient;



    @BeforeEach
    void setUp() {

        ingredient = new Ingredient();
    }
    @Test
    void getId() {
        Long id = 5L;

        ingredient.setId(id);

        assertEquals(id, ingredient.getId());
    }

    @Test
    void getDescription() {
        String description = "Jfoofof";

        ingredient.setDescription(description);

        assertEquals(description, ingredient.getDescription());
    }

    @Test
    void getRecipe() {

        Recipe recipe = new Recipe();
        recipe.setId(2L);


        recipe.getIngredients().add(ingredient);
      ingredient.setRecipe(recipe);

        assertEquals(2l, ingredient.getRecipe().getId());
    }


}