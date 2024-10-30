package ru.t1.practice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.practice.dto.*;
import ru.t1.practice.service.TechnologyService;

@RestController
@AllArgsConstructor
public class TechnologyController {
    private final TechnologyService technologyService;

    @Operation(summary = "Получение списка технологий")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Список технологий получен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TechnologyListResponse.class)
                            )
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Неверно введены категория и секцияе",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BadRequestCategoryAndSectionResponse.class)
                            )
                    }),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка на стороне сервера",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ServerErrorResponse.class)
                            )
                    })
    })
    @GetMapping("/api/technology")
    public ResponseEntity<TechnologyListResponse> getTechnologies(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String section
    ) {
        return ResponseEntity.ok(technologyService.getFilteredTechnologies(category, section));
    }
}
