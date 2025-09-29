package com.VictorHugoBatista.personal_note_manager.common.http;

public class CustomResponseEntity<T> {
    private String message;
    private T data;

    public CustomResponseEntity(String message) {
        this.message = message;
    }

    public CustomResponseEntity(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
