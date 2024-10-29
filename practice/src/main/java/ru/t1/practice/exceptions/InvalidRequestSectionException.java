package ru.t1.practice.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidRequestSectionException extends BaseException{
    private final String section;

    public InvalidRequestSectionException(String message, String section) {
        super(HttpStatus.valueOf(400), message);
        this.section = section;
    }
}
