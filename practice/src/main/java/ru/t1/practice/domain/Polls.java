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
@Table(name = "polls")
public class Polls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pollId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;

    @ManyToOne
    @JoinColumn(name = "tech_id")
    private Technologies techId;

    @ManyToOne
    @JoinColumn(name = "ring_id")
    private Rings ringId;

    private Timestamp time;
}
