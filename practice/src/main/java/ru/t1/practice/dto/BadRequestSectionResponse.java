package ru.t1.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BadRequestSectionResponse {
    private String error;
    private BadRequestSectionDetails details;
}
