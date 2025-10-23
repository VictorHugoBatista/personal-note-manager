package com.VictorHugoBatista.personal_note_manager.users.v1.service.Impl;

import org.springframework.stereotype.Service;

import com.VictorHugoBatista.personal_note_manager.users.v1.model.User;
import com.VictorHugoBatista.personal_note_manager.users.v1.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    @Override
    public User create(User user) {
        return user;
    }
}
