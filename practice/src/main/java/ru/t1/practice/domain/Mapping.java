package ru.t1.practice.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "mapping")
public class Mapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roleId;

    @ManyToOne
    @JoinColumn(name = "func_id")
    private Functions funcId;
}
