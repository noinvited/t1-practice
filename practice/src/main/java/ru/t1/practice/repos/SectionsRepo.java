package ru.t1.practice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.t1.practice.domain.Sections;

public interface SectionsRepo extends JpaRepository<Sections, Long> {
    boolean existsBySecName(String secName);
}
