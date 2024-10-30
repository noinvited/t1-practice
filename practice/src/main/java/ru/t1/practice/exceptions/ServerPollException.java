package ru.t1.practice.exceptions;

import org.springframework.http.HttpStatus;

public class ServerPollException extends BaseException{
    public ServerPollException(String message) {
        super(HttpStatus.valueOf(500), message);
    }
}
