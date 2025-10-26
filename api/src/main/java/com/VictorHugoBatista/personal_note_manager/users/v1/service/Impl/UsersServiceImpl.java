package com.VictorHugoBatista.personal_note_manager.users.v1.service.Impl;

import org.springframework.stereotype.Service;

import com.VictorHugoBatista.personal_note_manager.users.v1.encoder.PasswordEncoder;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.User;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos.UserDataOpen;
import com.VictorHugoBatista.personal_note_manager.users.v1.repository.UserRepository;
import com.VictorHugoBatista.personal_note_manager.users.v1.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDataOpen create(User user) {
        user.initDates();
        user.initStatus();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        var createdUser = repository.save(user);

        return createdUser.getOpenData();
    }
}
