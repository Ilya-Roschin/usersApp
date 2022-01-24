package com.java.training.application.exception;

import com.java.training.application.dto.ErrorDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorDto handleException(EntityNotFoundException e) {
        return new ErrorDto(e.getMessage());
    }
}
