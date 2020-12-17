package Franciscobusleiman.recipes.recipes.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureTest {

    UnitOfMeasure unitOfMeasure;

    @BeforeEach
    void setUp() {
        unitOfMeasure = new UnitOfMeasure();
    }

    @Test
    void getId() {

        Long id = 4L;
        unitOfMeasure.setId(id);

        assertEquals(4L, unitOfMeasure.getId());
    }
}