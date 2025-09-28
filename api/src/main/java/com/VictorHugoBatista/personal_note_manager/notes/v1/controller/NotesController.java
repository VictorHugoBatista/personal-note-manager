package com.VictorHugoBatista.personal_note_manager.notes.v1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;
import com.VictorHugoBatista.personal_note_manager.notes.v1.model.dtos.NoteCreateDto;
import com.VictorHugoBatista.personal_note_manager.notes.v1.model.dtos.NoteUpdateDto;
import com.VictorHugoBatista.personal_note_manager.notes.v1.service.NotesService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "notes", description = "Notes related endpoints")
public class NotesController {
    private final NotesService service;

    public NotesController(NotesService service) {
        this.service = service;
    }

    @GetMapping("/notes")
    public List<Note> list() {
        return service.list();
    }

    @GetMapping("/note/{id}")
    public Note detail(
        @Parameter(in = ParameterIn.PATH,
        example = "08a0ce52-489e-4ddd-8742-f8ace4a004a0")
        @PathVariable("id") String id
    ) {
        return this.service.detail(id);
    }

    @PostMapping("/note")
    public Note create(@Valid @RequestBody NoteCreateDto noteDto) {
        return this.service.create(noteDto.toNote());
    }

    @PutMapping("/note/{id}")
    public Note update(
        @Parameter(in = ParameterIn.PATH,
        example = "08a0ce52-489e-4ddd-8742-f8ace4a004a0")
        @PathVariable("id") String id,
        @Valid @RequestBody NoteUpdateDto noteDto
    ) {
        return service.update(noteDto.toNote(id));
    }

    @DeleteMapping("/note/{id}")
    public Note delete(
        @Parameter(in = ParameterIn.PATH,
        example = "08a0ce52-489e-4ddd-8742-f8ace4a004a0")
        @PathVariable("id") String id
    ) {
        return service.delete(id);
    }
}
