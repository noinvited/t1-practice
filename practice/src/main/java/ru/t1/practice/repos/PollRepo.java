package ru.t1.practice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.t1.practice.domain.Polls;

public interface PollRepo extends JpaRepository<Polls, Integer> {
}
