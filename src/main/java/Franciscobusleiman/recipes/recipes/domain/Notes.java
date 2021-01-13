package Franciscobusleiman.recipes.recipes.domain;

import lombok.*;


import java.util.Objects;
import java.util.UUID;

@Data

public class Notes {


    private String id = UUID.randomUUID().toString();

    private String notes;



    public Notes(){

    }

}
