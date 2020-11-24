package Franciscobusleiman.recipes.recipes.Repositories;

import Franciscobusleiman.recipes.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    public Optional<Recipe> finByDescription(String description);
}
