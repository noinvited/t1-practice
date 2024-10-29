package ru.t1.practice.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidRequestCategoryException extends BaseException{
    private final String category;

    public InvalidRequestCategoryException(String message, String category) {
        super(HttpStatus.valueOf(400), message);
        this.category = category;
    }
}
