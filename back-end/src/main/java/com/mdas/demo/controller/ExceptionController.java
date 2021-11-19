package com.mdas.demo.controller;

import com.mdas.demo.exception.UserNotFoundException;
import com.mdas.demo.exception.ValidateUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ValidateUserException.class})
    public HttpStatus handleValidateException() {
        return HttpStatus.BAD_REQUEST;
    }

    @ExceptionHandler(value = {UserNotFoundException.class, NullPointerException.class})
    public HttpStatus handleUserException() {
        return HttpStatus.NOT_FOUND;
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    public HttpStatus handleUserAccess() {
        return HttpStatus.FORBIDDEN;
    }



}
