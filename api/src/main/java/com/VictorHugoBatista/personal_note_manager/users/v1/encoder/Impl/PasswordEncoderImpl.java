package com.VictorHugoBatista.personal_note_manager.users.v1.encoder.Impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.VictorHugoBatista.personal_note_manager.users.v1.encoder.PasswordEncoder;

public class PasswordEncoderImpl implements PasswordEncoder {
    private static PasswordEncoder instance;

    private final org.springframework.security.crypto.password.PasswordEncoder encoder;

    public static PasswordEncoder getInstance() {
        if (instance == null) {
            instance = new PasswordEncoderImpl();
        }

        return instance;
    }

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

    private PasswordEncoderImpl() {
        encoder = new BCryptPasswordEncoder();
    }
}
