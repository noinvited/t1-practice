package ru.t1.practice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.t1.practice.domain.Technologies;

public interface TechnologyRepo extends JpaRepository<Technologies, Integer> {
}
