package ru.t1.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BadRequestCategoryResponse {
    private String error;
    private BadRequestCategoryDetails details;
}
