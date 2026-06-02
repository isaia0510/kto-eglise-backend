package com.example.eglise.entity.id;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonSakrametaId implements Serializable {
    private String idPersonne;
    private String idSakrameta;
}
