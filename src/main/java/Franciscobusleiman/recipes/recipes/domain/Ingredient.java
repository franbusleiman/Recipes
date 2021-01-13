package Franciscobusleiman.recipes.recipes.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.math.BigDecimal;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@ToString(exclude = {"recipe"})

public class Ingredient {

@Id
private String id = UUID.randomUUID().toString();
    private String description;
    private BigDecimal amount;
@DBRef
    private Recipe recipe;
@DBRef
    private UnitOfMeasure unitOfMeasure;


    public Ingredient(){

    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe){
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
    }

}
