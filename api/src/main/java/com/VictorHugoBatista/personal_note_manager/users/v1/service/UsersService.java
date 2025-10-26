package com.VictorHugoBatista.personal_note_manager.users.v1.service;

import java.util.Optional;

import com.VictorHugoBatista.personal_note_manager.users.v1.model.User;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.domain.UserLogin;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos.UserDataOpen;

public interface UsersService {
    public UserDataOpen create(User user);
    public Optional<String> login(UserLogin userLogin);
}
