package ru.t1.practice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Описание ошибки отправки опроса")
public class PollErrorResponse{
    private Integer code;
    private String message;
}
