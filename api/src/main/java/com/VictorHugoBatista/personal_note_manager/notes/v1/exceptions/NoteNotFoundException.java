package com.VictorHugoBatista.personal_note_manager.notes.v1.exceptions;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(String message) {
        super(message);
    }
}
