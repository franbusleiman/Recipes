package Franciscobusleiman.recipes.recipes.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"categories", "ingredients"})
@ToString(exclude = {"ingredients"})
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notes_id")
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
    @JoinTable (name = "recipe_category",
    joinColumns = @JoinColumn( name = "category_id"),
    inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }

}
