package com.VictorHugoBatista.personal_note_manager.packages.jwt;

public interface JwtUtils {
    public String create(String id);
    public String validate(String token);
}
