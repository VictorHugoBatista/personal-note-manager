package com.VictorHugoBatista.personal_note_manager.packages.jwt;

import java.util.Map;

public interface JwtUtils {
    public String create(Map<String, ?> data);
}
