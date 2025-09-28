package com.VictorHugoBatista.personal_note_manager.notes.v1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;

public interface NoteRepository extends MongoRepository<Note, String> {
}
