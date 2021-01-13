package Franciscobusleiman.recipes.recipes.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class UnitOfMeasure {

    private String id = UUID.randomUUID().toString();
    private String uom;

    public UnitOfMeasure(){

    }


}
