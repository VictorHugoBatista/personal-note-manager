package com.VictorHugoBatista.personal_note_manager.notes.v1.service.Impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;
import com.VictorHugoBatista.personal_note_manager.notes.v1.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService {
    @Override
    public Note detail(UUID id) {
        return new Note(id, "a", "b", "preview");
    }

    @Override
    public Note create(Note note) {
        return note;
    }

    @Override
    public Note update(Note note) {
        return note;
    }

    @Override
    public Note delete(UUID id) {
        return new Note(id, "a", "b", "preview");
    }
}
