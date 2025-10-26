package com.VictorHugoBatista.personal_note_manager.users.v1.model.domain;

import com.VictorHugoBatista.personal_note_manager.users.v1.encoder.PasswordEncoder;
import com.VictorHugoBatista.personal_note_manager.users.v1.encoder.Impl.PasswordEncoderImpl;

public class UserLogin {
    private String email;
    private String password;

    public UserLogin setEmail(String email) {
        this.email = email;

        return this;
    }

    public UserLogin setPassword(String password) {
        PasswordEncoder encoder = PasswordEncoderImpl.getInstance();
        this.password = encoder.encode(password);

        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
