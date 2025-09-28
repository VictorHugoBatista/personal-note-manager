package com.VictorHugoBatista.personal_note_manager.notes.v1.repository.Impl;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;
import com.VictorHugoBatista.personal_note_manager.notes.v1.repository.NoteRepository;

@Repository
public class NoteRepositoryImpl implements NoteRepository {
    @Override
    public Note detail(UUID id) {
        return new Note(id, "a", "b", "preview");
    }
}
