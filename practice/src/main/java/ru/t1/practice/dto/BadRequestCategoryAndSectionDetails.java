package ru.t1.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BadRequestCategoryAndSectionDetails {
    private String category;
    private String section;
}
