package ru.t1.practice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Неправильный ввод параметра запроса")
public class BadRequestSectionResponse {
    private String error;
    private BadRequestSectionDetails details;
}
