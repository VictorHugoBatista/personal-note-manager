package com.VictorHugoBatista.personal_note_manager.users.v1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.VictorHugoBatista.personal_note_manager.users.v1.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
