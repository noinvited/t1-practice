package ru.t1.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TechnologyListResponse {
    private List<TechnologyResponse> technologies;
}
