package com.VictorHugoBatista.personal_note_manager.notes.v1.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.VictorHugoBatista.personal_note_manager.common.http.CustomResponseEntity;
import com.VictorHugoBatista.personal_note_manager.common.http.HttpHelpers;
import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;
import com.VictorHugoBatista.personal_note_manager.notes.v1.model.dtos.NoteCreateDto;
import com.VictorHugoBatista.personal_note_manager.notes.v1.model.dtos.NoteUpdateDto;
import com.VictorHugoBatista.personal_note_manager.notes.v1.service.NotesService;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos.UserDataOpen;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "notes", description = "Notes related endpoints")
@SecurityRequirement(name = "Authorization")
public class NotesController {
    private final NotesService service;
    private final HttpHelpers http;

    public NotesController(NotesService service, HttpHelpers http) {
        this.service = service;
        this.http = http;
    }

    @GetMapping("/notes")
    public ResponseEntity<CustomResponseEntity<Page<Note>>> list(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "2") int sizePerPage,
        @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection,
        @RequestParam(defaultValue = "id") String sortField,
        Authentication auth
    ) {
        addUserToService(auth);

        Pageable pageable = PageRequest.of(page, sizePerPage, sortDirection, sortField);
        Page<Note> response = service.list(pageable);

        return http.buildResponse("Notes list fetched with success", response, HttpStatus.OK);
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<CustomResponseEntity<Note>> detail(
        @Parameter(in = ParameterIn.PATH,
        example = "68d97abd86f4f62fb756e958")
        @PathVariable("id") String id,
        Authentication auth
    ) {
        addUserToService(auth);

        Note response = this.service.detail(id);

        return http.buildResponse("Note detail fetched with success", response, HttpStatus.OK);
    }

    @PostMapping("/note")
    public ResponseEntity<CustomResponseEntity<Note>> create(
        @Valid @RequestBody NoteCreateDto noteDto,
        Authentication auth
    ) {
        addUserToService(auth);

        Note response = this.service.create(noteDto.toNote());

        return http.buildResponse("Note created with success", response, HttpStatus.OK);
    }

    @PutMapping("/note/{id}")
    public ResponseEntity<CustomResponseEntity<Note>> update(
        @Parameter(in = ParameterIn.PATH,
        example = "68d97abd86f4f62fb756e958")
        @PathVariable("id") String id,
        @Valid @RequestBody NoteUpdateDto noteDto,
        Authentication auth
    ) {
        addUserToService(auth);

        Note response = service.update(noteDto.toNote(id));

        return http.buildResponse("Note updated with success", response, HttpStatus.OK);
    }

    @DeleteMapping("/note/{id}")
    public ResponseEntity<CustomResponseEntity<Note>> delete(
        @Parameter(in = ParameterIn.PATH,
        example = "68d97abd86f4f62fb756e958")
        @PathVariable("id") String id,
        Authentication auth
    ) {
        addUserToService(auth);

        Note response = service.delete(id);

        return http.buildResponse("Note deleted with success", response, HttpStatus.OK);
    }

    private void addUserToService(Authentication auth) {
        var userLogged = (UserDataOpen) auth.getPrincipal();
        this.service.setUser(userLogged);
    }
}
