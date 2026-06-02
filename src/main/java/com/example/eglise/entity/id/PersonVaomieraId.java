package com.example.eglise.entity.id;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonVaomieraId implements Serializable {
    private String idPersonne;
    private String idVaomiera;
}
