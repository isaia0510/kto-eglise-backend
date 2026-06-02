package com.example.eglise.entity;

import com.example.eglise.entity.id.PersonSakrametaId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "person_sakrameta")
@IdClass(PersonSakrametaId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonSakrameta {
    @Id
    @Column(name = "id_personne")
    private String idPersonne;

    @Id
    @Column(name = "id_sakrameta")
    private String idSakrameta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_personne", insertable = false, updatable = false)
    private Personne personne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sakrameta", insertable = false, updatable = false)
    private Sakrameta sakrameta;

    @Column(name = "date_voray")
    private LocalDate dateVoray;
}
