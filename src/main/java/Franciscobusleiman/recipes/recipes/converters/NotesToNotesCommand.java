package Franciscobusleiman.recipes.recipes.converters;

import Franciscobusleiman.recipes.recipes.commands.NotesCommand;
import Franciscobusleiman.recipes.recipes.domain.Notes;
import com.sun.istack.Nullable;
import org.springframework.core.convert.converter.Converter;

public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Nullable
    @Override
    public NotesCommand convert(Notes notes) {
        if (notes == null) {
            return null;
        }

        NotesCommand notesCommand = new NotesCommand();

        notesCommand.setId(notes.getId());
        notesCommand.setNotes(notes.getNotes());

        return notesCommand;
    }
}