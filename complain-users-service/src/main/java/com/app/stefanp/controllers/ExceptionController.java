package com.app.stefanp.controllers;


import com.app.stefanp.dto.ResponseData;
import com.app.stefanp.exceptions.RegisterServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController
{
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData handleUserServiceException(Exception e) {
        return ResponseData
                .builder()
                .error(e.getMessage())
                .build();
    }

}
