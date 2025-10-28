package com.VictorHugoBatista.personal_note_manager.notes.v1.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.VictorHugoBatista.personal_note_manager.notes.v1.exceptions.NoteNotFoundException;
import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;
import com.VictorHugoBatista.personal_note_manager.notes.v1.repository.NoteRepository;
import com.VictorHugoBatista.personal_note_manager.notes.v1.service.NotesService;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos.UserDataOpen;

@Service
public class NotesServiceImpl implements NotesService {
    private final NoteRepository repository;
    private UserDataOpen user;

    public NotesServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Note> list(Pageable pageable) {
        var userId = user.getId();

        return repository.findAll(userId, pageable);
    }

    @Override
    public Note detail(String id) {
        var userId = user.getId();

        var note = repository.findById(id, userId);

        if (note.isEmpty()) {
            throw new NoteNotFoundException( String.format("Note id %s doesn't exist", id));
        }

        return note.get();
    }

    @Override
    public Note create(Note note) {
        var userId = user.getId();

        note.setUserId(userId);

        return repository.insert(note);
    }

    @Override
    public Note update(Note note) {
        var noteFromDatabase = detail(note.getId());
        var nodeUpdated = noteFromDatabase
            .setTitle(note.getTitle())
            .setContent(note.getContent());

        return repository.save(nodeUpdated);
    }

    @Override
    public Note delete(String id) {
        var note = detail(id);
        repository.deleteById(id);
        return note;
    }

    @Override
    public void setUser(UserDataOpen user) {
        this.user = user;
    }
}
