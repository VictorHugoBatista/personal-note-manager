package com.VictorHugoBatista.personal_note_manager.users.v1.model.dtos;

import java.util.Date;

import com.VictorHugoBatista.personal_note_manager.users.v1.model.UserStatus;

public class UserDataOpen {
    private String email;
    private String name;
    private UserStatus status;
    private Date createdAt;
    private Date updatedAt;

    public UserDataOpen setEmail(String email) {
        this.email = email;

        return this;
    }

    public UserDataOpen setName(String name) {
        this.name = name;

        return this;
    }

    public UserDataOpen setStatus(UserStatus status) {
        this.status = status;

        return this;
    }

    public UserDataOpen setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public UserDataOpen setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
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
}
