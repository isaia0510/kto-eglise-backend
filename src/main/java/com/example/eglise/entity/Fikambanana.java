package com.example.eglise.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fikambanana")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fikambanana {

    @Id
    @Column(name = "id_fikambanana", insertable = false, updatable = false)
    private String idFikambanana;

    private String nom;
}
