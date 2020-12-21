package Franciscobusleiman.recipes.recipes.services;

import Franciscobusleiman.recipes.recipes.commands.IngredientCommand;
import Franciscobusleiman.recipes.recipes.converters.IngredientCommandToIngredient;
import Franciscobusleiman.recipes.recipes.converters.IngredientToIngredientCommand;
import Franciscobusleiman.recipes.recipes.converters.UnitOfMeasureCommandToUnitOfMeasure;
import Franciscobusleiman.recipes.recipes.converters.UnitOfMeasureToUnitOfMeasureCommand;
import Franciscobusleiman.recipes.recipes.domain.Ingredient;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.domain.UnitOfMeasure;
import Franciscobusleiman.recipes.recipes.repositories.RecipeRepository;
import Franciscobusleiman.recipes.recipes.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class IngredientServiceImplTest {

    IngredientService ingredientService;

    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;
    @Mock
    RecipeRepository recipeRepository;

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
        this.unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        ingredientService = new IngredientServiceImpl(recipeRepository, ingredientToIngredientCommand, ingredientCommandToIngredient, unitOfMeasureRepository);
    }

    @Test
    void findRecipeAndIngredientById() {

        Recipe recipe = new Recipe();
       recipe.setDescription("sdfs");
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setDescription("sdffsd");
        ingredient1.setRecipe(recipe);
        ingredient1.setId(1L);
        recipe.getIngredients().add(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setDescription("sfdf");
        ingredient2.setRecipe(recipe);
        ingredient2.setId(2L);
        recipe.getIngredients().add(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setDescription("wefawe");
        ingredient3.setRecipe(recipe);
        ingredient3.setId(3L);
        recipe.getIngredients().add(ingredient3);


Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        IngredientCommand ingredientCommand = ingredientService.findRecipeAndIngredientById(1L, 1L);
assertEquals(Long.valueOf(1L), ingredientCommand.getId());

verify(recipeRepository, times(1)).findById(anyLong());


    }

    @Test
    void deleteIngredient() {

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);


        recipe.getIngredients().add(ingredient1);
        recipe.getIngredients().add(ingredient2);
        recipe.getIngredients().add(ingredient3);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        ingredientService.deleteIngredient(1L, 3L);

        assertEquals(2, recipe.getIngredients().size());
        verify(recipeRepository, times(1)).findById(anyLong());
    }

    @Test
    void saveOrUpdateIngredient() {

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);

        recipe.getIngredients().add(ingredient);
        ingredient.setRecipe(recipe);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(1L);
        ingredientCommand.setRecipeId(1L);

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);
        unitOfMeasure.setUom("gramo");

        ingredientCommand.setUnitOfMeasure(unitOfMeasureToUnitOfMeasureCommand.convert(unitOfMeasure));

        Recipe savedRecipe = new Recipe();
        savedRecipe.getIngredients().add(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId(1L);

        when(recipeRepository.save(any())).thenReturn(savedRecipe);
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        when(unitOfMeasureRepository.findById(anyLong())).thenReturn(Optional.of(unitOfMeasure));

        IngredientCommand ingredientCommand1 = ingredientService.SaveOrUpdateIngredient(ingredientCommand);

        assertEquals(1L, ingredientCommand1.getId());
        verify(recipeRepository, times(1)).findById(anyLong());


    }
}