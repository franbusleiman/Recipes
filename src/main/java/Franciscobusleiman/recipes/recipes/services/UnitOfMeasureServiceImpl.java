package Franciscobusleiman.recipes.recipes.services;


import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.domain.UnitOfMeasure;
import Franciscobusleiman.recipes.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository){
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Set<UnitOfMeasure> getUoms() {

        Set<UnitOfMeasure> uoms = new HashSet<>();
        unitOfMeasureRepository.findAll().forEach(uoms::add);

        return uoms;
    }
}
