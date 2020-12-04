package Franciscobusleiman.recipes.recipes.converters;

import Franciscobusleiman.recipes.recipes.commands.NotesCommand;
import Franciscobusleiman.recipes.recipes.domain.Notes;
import com.sun.istack.Nullable;
import org.springframework.core.convert.converter.Converter;

public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Nullable
    @Override
    public Notes convert(NotesCommand notesCommand) {
        if(notesCommand == null){
            return null;
        }

        Notes notes = new Notes();
        notes.setNotes(notesCommand.getNotes());
        notes.setId(notesCommand.getId());

        return notes;
    }
}
