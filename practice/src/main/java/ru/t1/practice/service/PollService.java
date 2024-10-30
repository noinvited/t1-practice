package ru.t1.practice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.t1.practice.domain.Polls;
import ru.t1.practice.exceptions.InvalidRequestPollException;
import ru.t1.practice.exceptions.ServerPollException;
import ru.t1.practice.exceptions.TechnologyNotFoundPollException;
import ru.t1.practice.repos.PollRepo;
import ru.t1.practice.repos.RingRepo;
import ru.t1.practice.repos.TechnologyRepo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PollService {
    private final RingRepo ringRepo;
    private final TechnologyRepo technologyRepo;
    private final PollRepo pollRepo;

    public void save(Integer techId, String ring){
        if(!ringRepo.existsByRingName(ring))
            throw new InvalidRequestPollException("BAD_REQUEST");
        if(!technologyRepo.existsById(techId))
            throw new TechnologyNotFoundPollException("TECHNOLOGY_NOT_FOUND");

        try{
            Polls poll = new Polls();
            poll.setTechId(technologyRepo.findById(techId).get());
            poll.setRingId(ringRepo.findByRingName(ring));
            poll.setTime(Timestamp.valueOf(LocalDateTime.now()));
            //не добавляю UserId тк должны получать его из контекста авторизации, а его у нас нет
            pollRepo.save(poll);
        } catch(Exception e){
            throw new ServerPollException("INTERNAL_SERVER_ERROR");
        }
    }
}
