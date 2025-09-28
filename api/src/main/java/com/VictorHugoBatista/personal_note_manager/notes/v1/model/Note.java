package com.VictorHugoBatista.personal_note_manager.notes.v1.model;

import java.util.UUID;

public class Note {
    private UUID id;
    private String title;
    private String content;

    public Note(String title, String content) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
    }

    public Note(UUID id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
