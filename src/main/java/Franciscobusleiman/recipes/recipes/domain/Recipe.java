package Franciscobusleiman.recipes.recipes.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = {"categories", "ingredients"})
@ToString(exclude = {"ingredients", "categories"})
@Document
public class Recipe {


@Id
private String id = UUID.randomUUID().toString();

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    private String directions;

    private Difficulty difficulty;

    private Byte[] image;

    private Notes notes;

    private Set<Ingredient> ingredients = new HashSet<>();
    @DBRef
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }

}
