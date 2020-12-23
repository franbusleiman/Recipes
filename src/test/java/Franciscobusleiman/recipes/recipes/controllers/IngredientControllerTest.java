package Franciscobusleiman.recipes.recipes.controllers;

import Franciscobusleiman.recipes.recipes.commands.IngredientCommand;
import Franciscobusleiman.recipes.recipes.commands.RecipeCommand;
import Franciscobusleiman.recipes.recipes.domain.Ingredient;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.domain.UnitOfMeasure;
import Franciscobusleiman.recipes.recipes.repositories.RecipeRepository;
import Franciscobusleiman.recipes.recipes.services.IngredientService;
import Franciscobusleiman.recipes.recipes.services.RecipeService;
import Franciscobusleiman.recipes.recipes.services.UnitOfMeasureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class IngredientControllerTest {

    IngredientController ingredientController;

    @Mock
    RecipeService recipeService;
    @Mock
    IngredientService ingredientService;
    @Mock
    UnitOfMeasureService unitOfMeasureService;


    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        ingredientController = new IngredientController(recipeService, ingredientService, unitOfMeasureService);

        this.mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
    }

    @Test
    void getIngredients() throws Exception {
        RecipeCommand recipe = new RecipeCommand();

        recipe.setId(1L);

        when(recipeService.findCommandById(anyLong())).thenReturn(recipe);

mockMvc.perform(get("/recipe/1/ingredients"))
        .andExpect(status().isOk())
        .andExpect(view().name("recipe/ingredient/ingredients"))
        .andExpect(model().attributeExists("recipe"));

verify(recipeService, times(1)).findCommandById(anyLong());
    }

    @Test
    void getIngredient() throws Exception {

        IngredientCommand ingredientCommand = new IngredientCommand();


        when(ingredientService.findRecipeAndIngredientById(anyLong(), anyLong())).thenReturn(ingredientCommand);

        mockMvc.perform(get("/recipe/1/ingredient/1/showIngredient"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/showIngredient"))
                .andExpect(model().attributeExists("ingredient"));

        verify(ingredientService, times(1)).findRecipeAndIngredientById(anyLong(), anyLong());
    }

    @Test
    void updateIngredientes() throws Exception {
        IngredientCommand ingredientCommand = new IngredientCommand();


        when(ingredientService.findRecipeAndIngredientById(anyLong(), anyLong())).thenReturn(ingredientCommand);

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);

        UnitOfMeasure unitOfMeasure2 = new UnitOfMeasure();
        unitOfMeasure2.setId(2L);

        UnitOfMeasure unitOfMeasure3 = new UnitOfMeasure();
        unitOfMeasure3.setId(3L);

        Set<UnitOfMeasure> unitOfMeasureSet = new HashSet<>();

        unitOfMeasureSet.add(unitOfMeasure);
        unitOfMeasureSet.add(unitOfMeasure2);
        unitOfMeasureSet.add(unitOfMeasure3);

        when(unitOfMeasureService.getUoms()).thenReturn(unitOfMeasureSet);

        mockMvc.perform(get("/recipe/1/ingredient/1/updateIngredient"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/ingredientForm"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("uoms"));

        verify(ingredientService, times(1)).findRecipeAndIngredientById(anyLong(), anyLong());
        verify(unitOfMeasureService, times(1)).getUoms();


    }

    @Test
    void updateIngredient() throws Exception {

        IngredientCommand ingredientCommand = new IngredientCommand();

        when(ingredientService.SaveOrUpdateIngredient(ingredientCommand)).thenReturn(ingredientCommand);

        mockMvc.perform(post("/SaveIngredient")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/showIngredient"))
                .andExpect(model().attributeExists("ingredient"));

        verify(ingredientService, times(1)).SaveOrUpdateIngredient(ingredientCommand);

    }

    @Test
    void deleteIngredient() throws Exception {

        mockMvc.perform(get("/recipe/1/ingredient/1/deleteIngredient"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/index"));

verify(ingredientService, times(1)).deleteIngredient(anyLong(), anyLong());
    }

    @Test
    void newIngredient() throws Exception {

        Set<UnitOfMeasure> unitOfMeasureSet = new HashSet<>();

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);

        UnitOfMeasure unitOfMeasure2 = new UnitOfMeasure();
        unitOfMeasure2.setId(2L);

        UnitOfMeasure unitOfMeasure3 = new UnitOfMeasure();
        unitOfMeasure3.setId(3L);

        unitOfMeasureSet.add(unitOfMeasure);
        unitOfMeasureSet.add(unitOfMeasure2);
        unitOfMeasureSet.add(unitOfMeasure3);

        when(unitOfMeasureService.getUoms()).thenReturn(unitOfMeasureSet);

        mockMvc.perform(get("/recipe/1/newIngredient"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/ingredientForm"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("uoms"));

        verify(unitOfMeasureService, times(1)).getUoms();


    }
}