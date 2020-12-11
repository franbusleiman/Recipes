package Franciscobusleiman.recipes.recipes.services;

import Franciscobusleiman.recipes.recipes.domain.UnitOfMeasure;
import Franciscobusleiman.recipes.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UnitOfMeasureService {


    public Set<UnitOfMeasure> getUoms();

}
