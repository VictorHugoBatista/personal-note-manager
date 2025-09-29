package com.VictorHugoBatista.personal_note_manager.common.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.VictorHugoBatista.personal_note_manager.common.http.HttpHelpers;

@ControllerAdvice
public class ExceltionHandler {
    @Value("${application.return-stack-trace-on-errors}")
    private String returnStackTrace;

    private final HttpHelpers http;

    public ExceltionHandler(HttpHelpers http) {
        this.http = http;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseError> handleGenericException(ResourceNotFoundException ex) {
        ResponseError exception = http.buildResponseError(ex, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleGenericException(Exception ex) {
        ResponseError exception = http.buildResponseError(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
