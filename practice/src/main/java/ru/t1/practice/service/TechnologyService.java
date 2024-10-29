package ru.t1.practice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.t1.practice.domain.Technologies;
import ru.t1.practice.dto.TechnologyListResponse;
import ru.t1.practice.dto.TechnologyResponse;
import ru.t1.practice.exceptions.InvalidRequestCategoryAndSectionException;
import ru.t1.practice.exceptions.InvalidRequestCategoryException;
import ru.t1.practice.exceptions.InvalidRequestSectionException;
import ru.t1.practice.repos.CategoriesRepo;
import ru.t1.practice.repos.SectionsRepo;
import ru.t1.practice.repos.TechnologyRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class TechnologyService {
    private final TechnologyRepo technologyRepo;
    private final CategoriesRepo categoriesRepo;
    private final SectionsRepo sectionsRepo;

    public TechnologyListResponse getFilteredTechnologies(String category, String section){
        checkFilters(category, section);

        List<Technologies> allTechnologies = technologyRepo.findAll();
        return new TechnologyListResponse(allTechnologies.stream()
                .filter(tech -> tech.getStatId().getStatId() != 5
                        && (category == null || tech.getCatId().getCatName().equals(category))
                        && (section == null || tech.getSecId().getSecName().equals(section)))
                .map(TechnologyResponse::new)
                .toList());
    }

    private void checkFilters(String category, String section){
        boolean existsByCatName = category == null || categoriesRepo.existsByCatName(category);
        boolean existsBySecName = section == null || sectionsRepo.existsBySecName(section);
        if(!existsByCatName && !existsBySecName)
            throw new InvalidRequestCategoryAndSectionException("Invalid query parameters", category, section);
        if(!existsByCatName)
            throw new InvalidRequestCategoryException("Invalid query parameters", category);
        if(!existsBySecName)
            throw new InvalidRequestSectionException("Invalid query parameters", section);
    }
}
