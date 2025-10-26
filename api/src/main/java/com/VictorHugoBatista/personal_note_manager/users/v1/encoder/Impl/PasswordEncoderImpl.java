package com.VictorHugoBatista.personal_note_manager.users.v1.encoder.Impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.VictorHugoBatista.personal_note_manager.users.v1.encoder.PasswordEncoder;

@Component
public class PasswordEncoderImpl implements PasswordEncoder {
    private final org.springframework.security.crypto.password.PasswordEncoder encoder;

    public PasswordEncoderImpl() {
        this.encoder = new BCryptPasswordEncoder();
    }

    public String encode(String password) {
        return encoder.encode(password);
    }
}
