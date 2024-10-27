package ru.t1.practice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "technologies")
public class Technologies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tech_id")
    private Integer techId;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Categories catId;

    @ManyToOne
    @JoinColumn(name = "sec_id")
    private Sections secId;

    @ManyToOne
    @JoinColumn(name = "ring_id")
    private Rings ringId;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "stat_id")
    private Statuses statId;

    private Timestamp updateTime;
}
