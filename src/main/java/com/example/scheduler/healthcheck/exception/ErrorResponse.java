package com.example.scheduler.healthcheck.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(List<Error> errors, LocalDateTime timestamp) {
    public ErrorResponse(Error error){
        this(List.of(error));
    }

    public ErrorResponse(List<Error> errors){
        this(errors,LocalDateTime.now());
    }

}
