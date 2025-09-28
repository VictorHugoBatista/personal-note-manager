package com.VictorHugoBatista.personal_note_manager.notes.v1.model.dtos;

import com.VictorHugoBatista.personal_note_manager.notes.v1.model.Note;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class NoteCreateDto {
    @NotEmpty(message = "The note title is required")
    @Size(min = 1, max = 100, message = "The length of the title must be between 1 and 100 characters")
    private String title;

    private String content;

    public NoteCreateDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Note toNote() {
        return new Note()
            .setTitle(title)
            .setContent(content);
    }
}
