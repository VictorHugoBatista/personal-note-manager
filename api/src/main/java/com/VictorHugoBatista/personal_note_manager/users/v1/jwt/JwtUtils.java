package com.VictorHugoBatista.personal_note_manager.users.v1.jwt;

import java.util.Map;

public interface JwtUtils {
    public String create(Map<String, ?> data);
}
