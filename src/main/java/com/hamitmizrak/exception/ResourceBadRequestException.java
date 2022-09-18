package com.hamitmizrak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ResourceBadRequestException {}

/*@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceBadRequestException extends RuntimeException {

    //parametreli constructor parameters
    public ResourceBadRequestException(String message) {
        super(message);
    }
}*/
