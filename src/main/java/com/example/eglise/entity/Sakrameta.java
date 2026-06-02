package com.example.eglise.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sakrameta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sakrameta {

    @Id
    @Column(name = "id_sakrameta", insertable = false, updatable = false)
    private String idSakrameta;

    private String nom;
}
