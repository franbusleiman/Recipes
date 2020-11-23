package Franciscobusleiman.recipes.recipes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uom;

    public UnitOfMeasure(){

    }

    public String getUom(){
        return this.uom;
    }
    public void setUom(String uom){
        this.uom = uom;
    }


}
