package ru.t1.practice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Сообщение о добавлении результата опроса")
public class PollResponse {
    private String message;
}
