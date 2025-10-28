package com.VictorHugoBatista.personal_note_manager.packages.encoder;

public interface PasswordEncoder {
    public String encode(String password);
    public boolean matches(String rawPassword, String encodedPassword);
}
