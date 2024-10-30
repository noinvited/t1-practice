package ru.t1.practice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.t1.practice.domain.Categories;

public interface CategoriesRepo extends JpaRepository<Categories, Long> {
    boolean existsByCatName(String catName);
}
