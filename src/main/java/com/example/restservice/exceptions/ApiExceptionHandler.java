package com.example.restservice.exceptions;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

/**
 * exception handler class
 * @author Amiel Lejzor
 */
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiRequestExceptions.class})
    public ResponseEntity<Object> handleApiRequestExceptions (ApiRequestExceptions e){
        HttpStatus badRequest=HttpStatus.BAD_REQUEST;
         ApiExceptions apiExceptions=new ApiExceptions(
                 e.getMessage(),
                 e,
                 badRequest,
                 ZonedDateTime.now()
         );
         return new ResponseEntity<>(apiExceptions,badRequest);
    }
}
