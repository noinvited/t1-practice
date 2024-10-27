package ru.t1.practice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "polls")
public class Polls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pollId;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Users> userId;

    @OneToMany
    @JoinColumn(name = "tech_id")
    private List<Technologies> techId;

    @ManyToOne
    @JoinColumn(name = "ring_id")
    private Rings ringId;

    private Timestamp time;
}
