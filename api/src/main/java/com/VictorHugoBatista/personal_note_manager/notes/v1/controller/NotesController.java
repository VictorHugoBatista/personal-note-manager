package com.VictorHugoBatista.personal_note_manager.notes.v1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VictorHugoBatista.personal_note_manager.common.http.CustomResponseEntity;
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
    public ResponseEntity<CustomResponseEntity<Object>> list() {
        var response = service.list();

        return buildResponse("Notes list fetched with success", response, HttpStatus.OK);
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<CustomResponseEntity<Object>> detail(
        @Parameter(in = ParameterIn.PATH,
        example = "08a0ce52-489e-4ddd-8742-f8ace4a004a0")
        @PathVariable("id") String id
    ) {
        var response = this.service.detail(id);

        return buildResponse("Note detail fetched with success", response, HttpStatus.OK);
    }

    @PostMapping("/note")
    public ResponseEntity<CustomResponseEntity<Object>> create(@Valid @RequestBody NoteCreateDto noteDto) {
        var response = this.service.create(noteDto.toNote());

        return buildResponse("Note created with success", response, HttpStatus.OK);
    }

    @PutMapping("/note/{id}")
    public ResponseEntity<CustomResponseEntity<Object>> update(
        @Parameter(in = ParameterIn.PATH,
        example = "08a0ce52-489e-4ddd-8742-f8ace4a004a0")
        @PathVariable("id") String id,
        @Valid @RequestBody NoteUpdateDto noteDto
    ) {
        var response = service.update(noteDto.toNote(id));

        return buildResponse("Note updated with success", response, HttpStatus.OK);
    }

    @DeleteMapping("/note/{id}")
    public ResponseEntity<CustomResponseEntity<Object>> delete(
        @Parameter(in = ParameterIn.PATH,
        example = "08a0ce52-489e-4ddd-8742-f8ace4a004a0")
        @PathVariable("id") String id
    ) {
        var response = service.delete(id);

        return buildResponse("Note deleted with success", response, HttpStatus.OK);
    }

    private ResponseEntity<CustomResponseEntity<Object>> buildResponse(String message, Object data, HttpStatus status) {
        return new ResponseEntity<>(new CustomResponseEntity<>(message, data), status);
    }
}
