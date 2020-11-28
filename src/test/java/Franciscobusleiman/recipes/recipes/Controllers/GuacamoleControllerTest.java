package Franciscobusleiman.recipes.recipes.Controllers;

import Franciscobusleiman.recipes.recipes.Repositories.RecipeRepository;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class GuacamoleControllerTest {

    GuacamoleController guacamoleController;

    @Mock
    Model model;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        guacamoleController = new GuacamoleController(recipeRepository);
    }

    @Test
    void getRecetas() {


        Recipe guacamole = new Recipe();

        when(recipeRepository.findByDescription(anyString())).thenReturn(Optional.of(guacamole));

        String cadena = guacamoleController.getRecetas(model);

        assertEquals("guacamole.html", cadena);


        verify(model, times(1)).addAttribute("guacamole", recipeRepository.findByDescription("guacamole").get());


    }
}