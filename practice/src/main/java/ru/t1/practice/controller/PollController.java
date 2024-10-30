package ru.t1.practice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.practice.dto.*;
import ru.t1.practice.service.PollService;

@RestController
@AllArgsConstructor
public class PollController {
    private final PollService pollService;

    @Operation(summary = "Добавление результата опроса")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Результат опроса успешно добавлен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PollResponse.class)
                            )
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Кольцо не найдено",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PollErrorResponse.class)
                            )
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Технология не найдена",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PollErrorResponse.class)
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
    @PostMapping("/poll")
    public ResponseEntity<PollResponse> addNewPoll(@RequestBody PollRequest pollRequest) {
        pollService.save(pollRequest.getTech_id(), pollRequest.getRingResult());
        return ResponseEntity.status(201).body(new PollResponse("Результат опроса успешно добавлен"));
    }
}
