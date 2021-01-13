package Franciscobusleiman.recipes.recipes.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class UnitOfMeasure {

    private String id = UUID.randomUUID().toString();
    private String uom;

    public UnitOfMeasure(){

    }


}
