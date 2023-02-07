package com.firstCODE.spring.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StudentNotFoudException extends RuntimeException {
    public StudentNotFoudException(String massage){
        super(massage);
    }
}
