package com.VictorHugoBatista.personal_note_manager.users.v1.model.domain;

public class UserLogin {
    private String email;
    private String password;

    public UserLogin setEmail(String email) {
        this.email = email;

        return this;
    }

    public UserLogin setPassword(String password) {
        this.password = password;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
