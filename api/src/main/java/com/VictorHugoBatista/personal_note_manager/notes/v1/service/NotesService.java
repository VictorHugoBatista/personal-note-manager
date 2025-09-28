package com.VictorHugoBatista.personal_note_manager.notes.v1.service;

import java.util.UUID;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;

public interface NotesService {
    public Note create(Note note);
    public Note update(Note note);
    public Note delete(UUID id);
}
