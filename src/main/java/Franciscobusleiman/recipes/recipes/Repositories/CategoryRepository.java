package Franciscobusleiman.recipes.recipes.Repositories;

import Franciscobusleiman.recipes.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    public Optional<Category> findByCategoryName(String categoryName);
}
