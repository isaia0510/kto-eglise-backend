package com.example.eglise.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @Column(name = "id_role", insertable = false, updatable = false)
    private String idRole;

    private String nom;
}