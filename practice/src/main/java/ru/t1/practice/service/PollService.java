package ru.t1.practice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.t1.practice.domain.Polls;
import ru.t1.practice.domain.Technologies;
import ru.t1.practice.repos.PollRepo;
import ru.t1.practice.repos.RingRepo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PollService {
    private final RingRepo ringRepo;
    private final PollRepo pollRepo;

    public void save(Integer techId, String ring){
        Polls poll = new Polls();

        Technologies tech = new Technologies();
        tech.setTechId(techId);
        poll.setTechId(List.of(tech));

        poll.setRingId(ringRepo.findByRingName(ring));
        poll.setTime(Timestamp.valueOf(LocalDateTime.now()));

        //не добавляю UserId тк должны получать его из контекста авторизации, а его у нас нет

        pollRepo.save(poll);
    }
}
