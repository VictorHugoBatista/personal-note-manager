package com.VictorHugoBatista.personal_note_manager.notes.v1.service;

import java.util.List;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;

public interface NotesService {
    public List<Note> list();
    public Note detail(String id);
    public Note create(Note note);
    public Note update(Note note);
    public Note delete(String id);
}
