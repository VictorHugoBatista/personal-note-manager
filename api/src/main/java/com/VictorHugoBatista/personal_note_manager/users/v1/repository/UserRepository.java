package com.VictorHugoBatista.personal_note_manager.users.v1.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.VictorHugoBatista.personal_note_manager.users.v1.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByEmail(String email);

    @Query(fields="{'password': 0}")
    public Optional<User> findById(String id) throws IllegalArgumentException;
}
