package Franciscobusleiman.recipes.recipes.repositories;

import Franciscobusleiman.recipes.recipes.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class RecipeRepositoryTest {
    @Autowired
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByDescription() {
        Optional<Recipe> recipe = recipeRepository.findByDescription("Guacamole");
        assertEquals("Guacamole", recipe.get().getDescription());
    }
}