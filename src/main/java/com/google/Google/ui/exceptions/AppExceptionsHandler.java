package com.google.Google.ui.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import utils.ErrorMessage;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request)
    {
        String messageDescription=ex.getLocalizedMessage();
        if(null==messageDescription)
            messageDescription=ex.toString();
        ErrorMessage message=new ErrorMessage(new Date(),messageDescription);
        return new ResponseEntity<>(message,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
