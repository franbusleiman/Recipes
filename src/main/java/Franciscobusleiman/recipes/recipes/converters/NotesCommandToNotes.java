package Franciscobusleiman.recipes.recipes.converters;

import Franciscobusleiman.recipes.recipes.commands.NotesCommand;
import Franciscobusleiman.recipes.recipes.domain.Notes;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {


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
