package Franciscobusleiman.recipes.recipes.commands;

import Franciscobusleiman.recipes.recipes.domain.Category;
import Franciscobusleiman.recipes.recipes.domain.Difficulty;
import Franciscobusleiman.recipes.recipes.domain.Ingredient;
import Franciscobusleiman.recipes.recipes.domain.Notes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Byte[] image;
    private NotesCommand notes;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Set<CategoryCommand> categories = new HashSet<>();
}
