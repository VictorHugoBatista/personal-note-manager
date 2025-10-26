package com.VictorHugoBatista.personal_note_manager.users.v1.service.Impl;

import org.springframework.stereotype.Service;

import com.VictorHugoBatista.personal_note_manager.users.v1.encoder.Impl.PasswordEncoderImpl;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.User;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.domain.UserLogin;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos.UserDataOpen;
import com.VictorHugoBatista.personal_note_manager.users.v1.repository.UserRepository;
import com.VictorHugoBatista.personal_note_manager.users.v1.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
    private final UserRepository repository;

    public UsersServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDataOpen create(User user) {
        user.initDates();
        user.initStatus();

        var createdUser = repository.save(user);

        return createdUser.getOpenData();
    }

    @Override
    public Boolean login(UserLogin userLogin) {
        var user = repository.findByEmail(userLogin.getEmail());

        if (user == null) {
            return false;
        }

        var encoder = PasswordEncoderImpl.getInstance();

        return encoder.matches(userLogin.getPassword(), user.getPassword());
    }
}
