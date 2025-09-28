package com.VictorHugoBatista.personal_note_manager.notes.v1.model;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class Note {
    private UUID id;
    private String title;
    private String content;
    private String preview;

    public Note(String title, String content) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.preview = StringUtils.substring(content, 0, 100);
    }

    public Note(UUID id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.preview = StringUtils.substring(content, 0, 100);
    }

    public Note(UUID id, String title, String content, String preview) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.preview = preview;
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

    public String getPreview() {
        return preview;
    }
}
