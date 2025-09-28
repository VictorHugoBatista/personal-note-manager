package com.VictorHugoBatista.personal_note_manager.notes.v1.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "notes", description = "Notes related endpoints")
public class NotesController {
    @GetMapping("/notes")
    public String list() {
        return "list";
    }

    @GetMapping("/note/{id}")
    public String detail(
        @Parameter(in = ParameterIn.PATH,
        example = "08a0ce52-489e-4ddd-8742-f8ace4a004a0")
        @PathVariable("id") UUID id
    ) {
        return "detail";
    }

    @PostMapping("/note")
    public String create() {
        return "created";
    }

    @PutMapping("/note/{id}")
    public String update(
        @Parameter(in = ParameterIn.PATH,
        example = "08a0ce52-489e-4ddd-8742-f8ace4a004a0")
        @PathVariable("id") UUID id
    ) {
        return "updated";
    }

    @DeleteMapping("/note/{id}")
    public String delete(
        @Parameter(in = ParameterIn.PATH,
        example = "08a0ce52-489e-4ddd-8742-f8ace4a004a0")
        @PathVariable("id") UUID id
    ) {
        return "deleted";
    }
}
