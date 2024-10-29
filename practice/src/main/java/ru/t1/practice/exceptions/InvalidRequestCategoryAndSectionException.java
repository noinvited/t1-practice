package ru.t1.practice.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidRequestCategoryAndSectionException extends BaseException{
    private final String category;
    private final String section;

    public InvalidRequestCategoryAndSectionException(String message, String category, String section) {
        super(HttpStatus.valueOf(400), message);
        this.category = category;
        this.section = section;
    }
}
