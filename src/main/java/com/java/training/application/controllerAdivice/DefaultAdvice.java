package com.java.training.application.controllerAdivice;

import com.java.training.application.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler()
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException e) {
        ErrorDto response = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
