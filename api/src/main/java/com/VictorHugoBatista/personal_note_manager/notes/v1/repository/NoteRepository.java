package com.VictorHugoBatista.personal_note_manager.notes.v1.repository;

import java.util.UUID;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;

public interface NoteRepository {
    public Note detail(UUID id);
}
