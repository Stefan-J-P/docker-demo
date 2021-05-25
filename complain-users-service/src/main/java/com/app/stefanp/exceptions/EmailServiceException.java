package com.app.stefanp.exceptions;

public class EmailServiceException extends RuntimeException
{
    public EmailServiceException(String message) {
        super(message);
    }
}
