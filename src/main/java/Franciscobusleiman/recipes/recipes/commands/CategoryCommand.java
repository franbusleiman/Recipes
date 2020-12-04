package Franciscobusleiman.recipes.recipes.commands;

import Franciscobusleiman.recipes.recipes.domain.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String CategoryName;
    private Set<RecipeCommand> recipes = new HashSet<>();

}
