package Franciscobusleiman.recipes.recipes.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Objects;
import java.util.UUID;

@Data

public class Notes {


    private String id = UUID.randomUUID().toString();

    private String notes;



    public Notes(){

    }

}
