package Franciscobusleiman.recipes.recipes.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    Recipe recipe;


    @BeforeEach
    void setUp() {
        recipe = new Recipe();
    }

    @Test
    void getId() {
        Long id = 4L;
        recipe.setId(id);

        assertEquals(id, recipe.getId());
    }

    @Test
    void getDescription() {

        String description = "descripcion";

        recipe.setDescription(description);

        assertEquals(description, recipe.getDescription());
    }

    @Test
    void getPrepTime() {
        Integer prepTime = 10;
        recipe.setPrepTime(prepTime);

        assertEquals(prepTime, recipe.getPrepTime());
    }

    @Test
    void getCookTime() {
        Integer coockTime = 25;
        recipe.setCookTime(coockTime);

        assertEquals(coockTime, recipe.getCookTime());
    }

    @Test
    void getNotes() {
        Notes nota = new Notes();

        recipe.setNotes(nota);

        assertEquals(nota, recipe.getNotes());
}

    @Test
    void getIngredients() {

        Ingredient ingrediente1 = new Ingredient();
        ingrediente1.setDescription("canela");

        Ingredient ingrediente2 = new Ingredient();
ingrediente2.setDescription("limon");

        Set<Ingredient> ingredientes = new HashSet<>();


        ingredientes.add(ingrediente1);
        ingredientes.add(ingrediente2);

        recipe.setIngredients(ingredientes);

        assertEquals(2, recipe.getIngredients().size());
    }

    @Test
    void getCategories() {
        Category categoria1 = new Category();
        categoria1.setCategoryName("mexicana");
        Category categoria2 = new Category();
        categoria2.setCategoryName("argentina");

        Set<Category> categorias = new HashSet<>();

        categorias.add(categoria1);
        categorias.add(categoria2);

        recipe.setCategories(categorias);

        assertEquals(2, recipe.getCategories().size());
    }
}