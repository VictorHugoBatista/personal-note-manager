package com.VictorHugoBatista.personal_note_manager.common.exceptions;

import org.springframework.http.HttpStatus;

public class ResponseError {
    private String error;
    private HttpStatus status;
    private StackTraceElement[] stackTrace;

    public ResponseError(String error, HttpStatus status) {
        this.error = error;
        this.status = status;
    }

    public ResponseError(String error, HttpStatus status, StackTraceElement[] stackTrace) {
        this.error = error;
        this.status = status;
        this.stackTrace = stackTrace;
    }

    public String getError() {
        return error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public StackTraceElement[] getStackTraceElement() {
        return stackTrace;
    }
}
