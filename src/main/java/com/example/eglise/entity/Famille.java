package com.example.eglise.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "famille")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Famille {
    @Id
    @Column(name = "id_famille", insertable = false, updatable = false)
    private String idFamille;

    @Column(name = "nom_famille")
    private String nomFamille;

    private String itompokolahy;

    private String itompokovavy;

    private String solotena;

    private String telephone;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_personne")
    private Personne responsable;
}
