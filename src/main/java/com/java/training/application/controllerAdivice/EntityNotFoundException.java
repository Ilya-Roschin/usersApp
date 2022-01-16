package com.java.training.application.controllerAdivice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "404 Not Found.";
    }
}
