package ru.t1.practice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Неправильный ввод параметров запроса")
public class BadRequestCategoryAndSectionResponse{
    private String error;
    private BadRequestCategoryAndSectionDetails details;
}
