package Franciscobusleiman.recipes.recipes.services;

import Franciscobusleiman.recipes.recipes.domain.UnitOfMeasure;
import Franciscobusleiman.recipes.recipes.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UnitOfMeasureServiceImplTest {

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    UnitOfMeasureService unitOfMeasureService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureRepository);
    }

    @Test
    void getUoms(){

        Set<UnitOfMeasure> uoms = new HashSet<>();

        UnitOfMeasure unitOfMeasure1 = new UnitOfMeasure();
        unitOfMeasure1.setId(1L);
        UnitOfMeasure unitOfMeasure2 = new UnitOfMeasure();
        unitOfMeasure2.setId(2L);

        uoms.add(unitOfMeasure1);
        uoms.add(unitOfMeasure2);

        when(unitOfMeasureService.getUoms()).thenReturn(uoms);

        assertEquals(2, unitOfMeasureService.getUoms().size());

        verify(unitOfMeasureRepository, times(1)).findAll();
    }
}