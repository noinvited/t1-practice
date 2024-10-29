package ru.t1.practice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.practice.dto.PollResponse;
import ru.t1.practice.service.PollService;

@RestController
@AllArgsConstructor
public class PollController {
    private final PollService pollService;

    @PostMapping("/poll")
    public ResponseEntity<PollResponse> addNewPoll(Integer tech_id,
                                                   String ringResult){
        pollService.save(tech_id, ringResult);
        return ResponseEntity.status(201).body(new PollResponse("Результат опроса успешно добавлен"));
    }
}
