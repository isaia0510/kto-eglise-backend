package com.example.eglise.entity;

import com.example.eglise.entity.id.PersonFikambananaId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "person_fikambanana")
@IdClass(PersonFikambananaId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonFikambanana {
    @Id
    @Column(name = "id_personne")
    private String idPersonne;

    @Id
    @Column(name = "id_fikambanana")
    private String idFikambanana;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_personne", insertable = false, updatable = false)
    private Personne personne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fikambanana", insertable = false, updatable = false)
    private Fikambanana fikambanana;

    @Column(name = "joined_at")
    private LocalDate joinedAt;

    @Column(name = "left_at")
    private LocalDate leftAt;
}