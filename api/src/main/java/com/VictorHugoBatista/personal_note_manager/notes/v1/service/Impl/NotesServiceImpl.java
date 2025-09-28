package com.VictorHugoBatista.personal_note_manager.notes.v1.service.Impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;
import com.VictorHugoBatista.personal_note_manager.notes.v1.repository.NoteRepository;
import com.VictorHugoBatista.personal_note_manager.notes.v1.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService {
    private final NoteRepository repository;

    public NotesServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Note detail(String id) {
        var note = repository.findById(id);

        if (note.isEmpty()) {
            throw new RuntimeException("my not found");
        }

        return note.get();
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
    public Note delete(String id) {
        return new Note()
            .setId(id);
    }
}
