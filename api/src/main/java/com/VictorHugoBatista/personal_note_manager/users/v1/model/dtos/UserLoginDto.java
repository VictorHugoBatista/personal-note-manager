package com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos;

import com.VictorHugoBatista.personal_note_manager.users.v1.model.domain.UserLogin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserLoginDto {
    @Email()
    @NotEmpty(message = "The user email is required")
    @Size(min = 10, max = 50, message = "The email must be between 10 and 50 characters long")
    private String email;

    @NotEmpty(message = "The user password is required")
    @Size(min = 8, max = 20, message = "The password must be between 8 and 20 characters long")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserLogin toDomain() {
        return new UserLogin()
            .setEmail(email)
            .setPassword(password);
    }
}
