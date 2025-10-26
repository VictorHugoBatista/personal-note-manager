package com.VictorHugoBatista.personal_note_manager.users.v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VictorHugoBatista.personal_note_manager.common.http.CustomResponseEntity;
import com.VictorHugoBatista.personal_note_manager.common.http.HttpHelpers;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos.UserCreateDto;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos.UserDataOpen;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos.UserLoginDto;
import com.VictorHugoBatista.personal_note_manager.users.v1.service.UsersService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "users", description = "Users related endpoints")
public class UsersController {
    private final UsersService service;
    private final HttpHelpers http;

    public UsersController(UsersService service, HttpHelpers http) {
        this.service = service;
        this.http = http;
    }

    @PostMapping("/user")
    public ResponseEntity<CustomResponseEntity<UserDataOpen>> create(@Valid @RequestBody UserCreateDto userDto) {
        var response = service.create(userDto.toUser());

        return http.buildResponse("User created with success",  response, HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity<CustomResponseEntity<UserLoginDto>> login(@Valid @RequestBody UserLoginDto userLoginDto) {

        return http.buildResponse("User logged with success",  userLoginDto, HttpStatus.OK);
    }
}
