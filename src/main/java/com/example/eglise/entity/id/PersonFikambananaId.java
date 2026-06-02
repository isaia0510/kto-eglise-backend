package com.example.eglise.entity.id;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonFikambananaId implements Serializable {
    private String idPersonne;
    private String idSakrameta;
}