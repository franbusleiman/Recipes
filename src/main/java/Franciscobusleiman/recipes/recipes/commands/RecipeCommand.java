package Franciscobusleiman.recipes.recipes.commands;

import Franciscobusleiman.recipes.recipes.domain.Category;
import Franciscobusleiman.recipes.recipes.domain.Difficulty;
import Franciscobusleiman.recipes.recipes.domain.Ingredient;
import Franciscobusleiman.recipes.recipes.domain.Notes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

    private Long id;

    @NotBlank
    @Size(min= 2, max=30, message = "El nombre de tu receta debe tener entre 2 y 30 caracteres")
    private String description;


    @Max(value = 3600, message = "Preparacion de 3600 min? May be an error")
    private Integer prepTime;


    @Max(value = 3600, message="Tiempo de coccion de 3600 min? May be an error")
    private Integer cookTime;

    private Integer servings;

    private String source;
    @URL(message = "Porfavor especifique una URL valida")
    private String url;

    private String directions;

    private Difficulty difficulty;

    private Byte[] image;

    private NotesCommand notes;

    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Set<CategoryCommand> categories = new HashSet<>();
}
