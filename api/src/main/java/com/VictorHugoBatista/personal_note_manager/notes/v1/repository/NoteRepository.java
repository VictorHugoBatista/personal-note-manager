package com.VictorHugoBatista.personal_note_manager.notes.v1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    @Query(value = "{}", fields="{'content': 0}")
    public List<Note> findAll();

    @Query(fields="{'preview': 0}")
    public Optional<Note> findById(String id);
}
