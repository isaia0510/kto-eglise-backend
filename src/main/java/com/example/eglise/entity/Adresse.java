package com.example.eglise.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "adresse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adresse {
    @Id
    @Column(name = "id_adresse", insertable = false, updatable = false)
    private String idAdresse;

    private String lot;

    private String toerana;

    private String fokontany;

    private String commune;

    private String apv;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "adresse")
    private List<Famille> familles;
}
