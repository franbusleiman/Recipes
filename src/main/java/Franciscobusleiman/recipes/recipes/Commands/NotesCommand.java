package Franciscobusleiman.recipes.recipes.Commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {
    private Long id;
    private String notes;
}
