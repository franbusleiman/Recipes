package Franciscobusleiman.recipes.recipes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String notes;



    public Notes(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notes notes = (Notes) o;
        return id.equals(notes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getNotes(){
        return this.notes;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }
}
