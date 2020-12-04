package Franciscobusleiman.recipes.recipes.controllers;

import Franciscobusleiman.recipes.recipes.repositories.RecipeRepository;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TortillaControllerTest {

    TortillaController tortillaController;

    @Mock
    Model model;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        tortillaController = new TortillaController(recipeRepository);
    }

    @Test
    void getRecetas() {

       Recipe tortilla = new Recipe();



       when(recipeRepository.findByDescription(anyString())).thenReturn(Optional.of(tortilla));


        String cadena = tortillaController.getRecetas(model);

        assertEquals("tortilla.html", cadena);

        verify(recipeRepository, times(1)).findByDescription(anyString());
        
       verify(model, times(1)).addAttribute("tortilla", recipeRepository.findByDescription("tortilla").get());


    }
}