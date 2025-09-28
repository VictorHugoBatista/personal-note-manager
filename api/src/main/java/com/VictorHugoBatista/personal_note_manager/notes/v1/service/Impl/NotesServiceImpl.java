package com.VictorHugoBatista.personal_note_manager.notes.v1.service.Impl;

import org.springframework.stereotype.Service;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;
import com.VictorHugoBatista.personal_note_manager.notes.v1.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService {
    @Override
    public Note create(Note note) {
        return note;
    }
}
