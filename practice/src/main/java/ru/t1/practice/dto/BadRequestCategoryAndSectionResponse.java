package ru.t1.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BadRequestCategoryAndSectionResponse{
    private String error;
    private BadRequestCategoryAndSectionDetails details;
}
