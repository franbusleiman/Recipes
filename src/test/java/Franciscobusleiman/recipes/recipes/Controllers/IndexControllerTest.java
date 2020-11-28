package Franciscobusleiman.recipes.recipes.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {
    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void getRecetas() {

        String cadena = indexController.getRecetas();

        assertEquals("index.html", cadena );
    }
}