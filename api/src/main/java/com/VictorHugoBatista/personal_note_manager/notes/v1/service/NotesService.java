package com.VictorHugoBatista.personal_note_manager.notes.v1.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos.UserDataOpen;

public interface NotesService {
    public Page<Note> list(Pageable pageable);
    public Note detail(String id);
    public Note create(Note note, UserDataOpen userLogged);
    public Note update(Note note);
    public Note delete(String id);
}
