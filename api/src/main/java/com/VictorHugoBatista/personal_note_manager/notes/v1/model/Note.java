package com.VictorHugoBatista.personal_note_manager.notes.v1.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("notes")
public class Note {
    @Id
    private String id;

    private String title;
    private String content;
    private String preview;

    public String getId() {
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

    public Note setId(String id) {
        this.id = id;

        return this;
    }

    public Note setTitle(String title) {
        if (title == null) {
            return this;
        }

        this.title = title;

        return this;
    }

    public Note setContent(String content) {
        if (content == null) {
            return this;
        }

        this.content = content;

        return setPreview(content);
    }

    private Note setPreview(String content) {
        if (content == null) {
            return this;
        }

        this.preview = StringUtils.substring(content, 0, 100);

        return this;
    }
}
