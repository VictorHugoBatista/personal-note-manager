package com.VictorHugoBatista.personal_note_manager.notes.v1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    @Query(value = "{'userId': ?1}", fields="{'content': 0}")
    public Page<Note> findAll(Pageable pageable, String userId);

    @Query(value = "{'id': ?0, 'userId': ?1}", fields="{'preview': 0}")
    public Optional<Note> findById(String id, String userId);
}
