package com.example.restservice.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiExceptions {
    private final String messege;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public ApiExceptions(String messege,
                         Throwable throwable,
                         HttpStatus httpStatus,
                         ZonedDateTime timeStamp) {
        this.messege = messege;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public String getMessege() {
        return messege;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
