package ru.t1.practice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Ошибка на стороне сервера")
public class ServerErrorResponse {
    private String error;
    private String message;
}
