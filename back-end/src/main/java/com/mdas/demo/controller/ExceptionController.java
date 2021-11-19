package com.mdas.demo.controller;

import com.mdas.demo.exception.UserNotFoundException;
import com.mdas.demo.exception.ValidateUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ValidateUserException.class})
    public HttpStatus handleValidateException() {
        return HttpStatus.BAD_REQUEST;
    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    public HttpStatus handleUserException() {
        return HttpStatus.NOT_FOUND;
    }

}
