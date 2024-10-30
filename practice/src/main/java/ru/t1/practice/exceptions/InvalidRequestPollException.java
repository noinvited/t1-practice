package ru.t1.practice.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidRequestPollException extends BaseException{
    public InvalidRequestPollException(String message) {
        super(HttpStatus.valueOf(400), message);
    }
}
