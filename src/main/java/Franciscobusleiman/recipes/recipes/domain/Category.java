package Franciscobusleiman.recipes.recipes.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@ToString(exclude = {"recipe"})
@Document
public class Category{
   @Id
    private String id = UUID.randomUUID().toString();
    private String categoryName;
 @DBRef
    private Set<Recipe> recipes = new HashSet<>();

    public Category(){

    }

    }

