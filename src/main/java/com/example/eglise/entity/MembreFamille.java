package com.example.eglise.entity;

import com.example.eglise.enums.RoleFamille;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "membre_famille")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MembreFamille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_personne")
    private Personne personne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_famille")
    private Famille famille;

    @Enumerated(EnumType.STRING)
    private RoleFamille role;
}
