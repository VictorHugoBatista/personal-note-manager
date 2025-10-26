package com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos;

import com.VictorHugoBatista.personal_note_manager.users.v1.model.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserCreateDto {
    @Email()
    @NotEmpty(message = "The user email is required")
    @Size(min = 10, max = 50, message = "The email must be between 10 and 50 characters long")
    private String email;

    @NotEmpty(message = "The user name is required")
    @Size(min = 4, max = 100, message = "The name must be between 4 and 100 characters long")
    private String name;

    @NotEmpty(message = "The user password is required")
    @Size(min = 8, max = 20, message = "The password must be between 8 and 20 characters long")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public User toUser() {
        return new User()
            .setEmail(email)
            .setName(name)
            .setPassword(password);
    }
}
