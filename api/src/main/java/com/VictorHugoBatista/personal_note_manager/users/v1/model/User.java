package com.VictorHugoBatista.personal_note_manager.users.v1.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.VictorHugoBatista.personal_note_manager.packages.encoder.Impl.PasswordEncoderImpl;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos.UserDataOpen;

@Document("users")
public class User {
    @Id
    private String id;

    @Indexed(unique=true)
    private String email;

    private String name;
    private String password;
    private UserStatus status;
    private Date createdAt;
    private Date updatedAt;

    public void initDates() {
        var now = new Date();
        setCreatedAt(now);
        setUpdatedAt(now);
    }

    public void initStatus() {
        setStatus(UserStatus.ACTIVE);
    }

    public User setEmail(String email) {
        this.email = email;

        return this;
    }

    public User setName(String name) {
        this.name = name;

        return this;
    }

    public User setPassword(String password) {
        var encoder = PasswordEncoderImpl.getInstance();
        this.password = encoder.encode(password);

        return this;
    }

    public User setStatus(UserStatus status) {
        this.status = status;

        return this;
    }

    public User setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public User setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;

        return this;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public UserDataOpen getOpenData() {
        return new UserDataOpen()
            .setId(id)
            .setName(name)
            .setEmail(email)
            .setStatus(status)
            .setCreatedAt(createdAt)
            .setUpdatedAt(updatedAt);
    }
}
