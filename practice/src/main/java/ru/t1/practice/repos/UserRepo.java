package ru.t1.practice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.t1.practice.domain.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
}
