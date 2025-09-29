package com.VictorHugoBatista.personal_note_manager.common.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.VictorHugoBatista.personal_note_manager.common.exceptions.ResponseError;

@Component
public class HttpHelpers {
    @Value("${application.return-stack-trace-on-errors}")
    private String returnStackTrace;

    public <T> ResponseEntity<CustomResponseEntity<T>> buildResponse(String message, T data, HttpStatus status) {
        return new ResponseEntity<>(new CustomResponseEntity<>(message, data), status);
    }

    public ResponseError buildResponseError(Exception ex, HttpStatus status) {
        if (! Boolean.parseBoolean(returnStackTrace)) {
            return new ResponseError(ex.getMessage(), status);
        }

        return new ResponseError(ex.getMessage(), status, ex.getStackTrace());
    }
}
