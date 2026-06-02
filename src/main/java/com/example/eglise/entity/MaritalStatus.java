package com.example.eglise.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "marital_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaritalStatus {
    @Id
    @Column(name = "id_marital", insertable = false, updatable = false)
    private String idMarital;

    private String nom;
}
