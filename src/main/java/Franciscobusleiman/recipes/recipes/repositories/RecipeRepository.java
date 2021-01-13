package Franciscobusleiman.recipes.recipes.repositories;

import Franciscobusleiman.recipes.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RecipeRepository extends CrudRepository<Recipe, String> {

    public Optional<Recipe> findByDescription(String description);
}
