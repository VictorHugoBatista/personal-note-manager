package com.VictorHugoBatista.personal_note_manager.users.v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VictorHugoBatista.personal_note_manager.common.http.CustomResponseEntity;
import com.VictorHugoBatista.personal_note_manager.common.http.HttpHelpers;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "users", description = "Users related endpoints")
public class UsersController {
    private final HttpHelpers http;

    public UsersController(HttpHelpers http) {
        this.http = http;
    }

    @PostMapping("/user")
    public ResponseEntity<CustomResponseEntity<String>> create() {
        return http.buildResponse("User created with success",  "teste", HttpStatus.OK);
    }
}
