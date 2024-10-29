package ru.t1.practice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.practice.dto.TechnologyListResponse;
import ru.t1.practice.service.TechnologyService;

import java.util.List;

@RestController
@AllArgsConstructor
public class TechnologyController {
    private final TechnologyService technologyService;

    @GetMapping("/api/technology")
    public ResponseEntity<TechnologyListResponse> getTechnologies(
                @RequestParam(required = false) String category,
                @RequestParam(required = false) String section
            ){
        return ResponseEntity.ok(technologyService.getFilteredTechnologies(category, section));
    }
}
