package Franciscobusleiman.recipes.recipes.Repositories;

import Franciscobusleiman.recipes.recipes.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    public Optional<UnitOfMeasure> findByUom(String uom);
}
