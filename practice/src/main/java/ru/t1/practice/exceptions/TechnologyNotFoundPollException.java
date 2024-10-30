package ru.t1.practice.exceptions;

import org.springframework.http.HttpStatus;

public class TechnologyNotFoundPollException extends BaseException{
    public TechnologyNotFoundPollException(String message) {
        super(HttpStatus.valueOf(404), message);
    }
}
