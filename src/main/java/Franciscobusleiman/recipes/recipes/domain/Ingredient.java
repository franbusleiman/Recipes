package Franciscobusleiman.recipes.recipes.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure;


    public Ingredient(){

    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
}
