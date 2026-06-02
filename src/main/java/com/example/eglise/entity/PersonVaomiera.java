package com.example.eglise.entity;

import com.example.eglise.entity.id.PersonVaomieraId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "person_vaomiera")
@IdClass(PersonVaomieraId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonVaomiera {
    @Id
    @Column(name = "id_personne")
    private String idPersonne;

    @Id
    @Column(name = "id_vaomiera")
    private String idVaomiera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_personne", insertable = false, updatable = false)
    private Personne personne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vaomiera", insertable = false, updatable = false)
    private Vaomiera vaomiera;

    @Column(name = "joined_at")
    private LocalDate joinedAt;

    @Column(name = "left_at")
    private LocalDate leftAt;
}
