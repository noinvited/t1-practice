package ru.t1.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServerErrorResponse {
    private String error;
    private String message;
}
