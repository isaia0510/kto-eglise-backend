package com.example.eglise.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vaomiera")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vaomiera {

    @Id
    @Column(name = "id_vaomiera", insertable = false, updatable = false)
    private String idVaomiera;

    private String nom;
}
