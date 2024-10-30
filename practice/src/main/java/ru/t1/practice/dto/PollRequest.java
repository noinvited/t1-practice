package ru.t1.practice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Данные опроса для записи")
public class PollRequest {
    private Integer tech_id;
    private String ringResult;
}
