package ru.t1.practice.dto;

import lombok.Data;
import ru.t1.practice.domain.Technologies;

@Data
public class TechnologyResponse {
    private int id;
    private String name;
    private String description;
    private String category;
    private String section;
    private String ring;

    public TechnologyResponse(Technologies technologies) {
        this.id = technologies.getTechId();
        this.name = technologies.getName();
        this.description = technologies.getDescription();
        this.category = technologies.getCatId().getCatName();
        this.section = technologies.getSecId().getSecName();
        this.ring = technologies.getRingId().getRingName();
    }
}
