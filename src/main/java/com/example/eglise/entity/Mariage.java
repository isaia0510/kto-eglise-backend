package com.example.eglise.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "mariage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mariage {
    @Id
    @Column(name = "id_mariage", insertable = false, updatable = false)
    private String idMariage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person1_id")
    private Personne person1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person2_id")
    private Personne person2;

    @Column(name = "date_religieux")
    private LocalDate dateReligieux;

    @Column(name = "date_civil")
    private LocalDate dateCivil;

    @Column(name = "is_catholic")
    private Boolean isCatholic;

    @Column(name = "church_name")
    private String churchName;

    @Column(name = "est_divorce")
    private Boolean estDivorce;
}
