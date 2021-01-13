package Franciscobusleiman.recipes.recipes.repositories;

import Franciscobusleiman.recipes.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {

    public Optional<Category> findByCategoryName(String categoryName);
}
