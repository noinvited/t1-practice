package ru.t1.practice.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServerTechnologyException extends BaseException{
    private final String error;

    public ServerTechnologyException(String error, String message) {
        super(HttpStatus.valueOf(500), message);
        this.error = error;
    }
}
