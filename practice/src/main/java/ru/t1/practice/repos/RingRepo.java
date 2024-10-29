package ru.t1.practice.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.t1.practice.domain.Rings;

public interface RingRepo extends JpaRepository<Rings, Long> {
    public Rings findByRingName(String ringName);
}
