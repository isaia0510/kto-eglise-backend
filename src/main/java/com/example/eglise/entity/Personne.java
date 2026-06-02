package com.example.eglise.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "personne")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Personne {

    @Id
    @Column(name = "id_personne", insertable = false, updatable = false)
    private String idPersonne;

    private String anarana;

    private String fanampiny;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    private String telephone;

    private String email;

    private String photo;

    private String metier;

    @Column(name = "est_mort")
    private Boolean estMort;

    @Column(name = "nom_pere")
    private String nomPere;

    @Column(name = "nom_mere")
    private String nomMere;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genre")
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marital")
    private MaritalStatus maritalStatus;
}
