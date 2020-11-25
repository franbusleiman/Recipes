package Franciscobusleiman.recipes.recipes.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Lob
    private String notes;



    public Notes(){

    }

}
