package com.example.eglise.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "eglise_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EgliseUser {
    @Id
    @Column(name = "id_user", insertable = false, updatable = false)
    private String idUser;

    private String username;

    private String password;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role")
    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_personne")
    private Personne personne;
}
