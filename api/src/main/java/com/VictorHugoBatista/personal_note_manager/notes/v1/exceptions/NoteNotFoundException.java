package com.VictorHugoBatista.personal_note_manager.notes.v1.exceptions;

import com.VictorHugoBatista.personal_note_manager.common.exceptions.ResourceNotFoundException;

public class NoteNotFoundException extends ResourceNotFoundException {
    public NoteNotFoundException(String message) {
        super(message);
    }
}
