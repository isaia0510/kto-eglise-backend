package com.example.eglise.dto.request;
import com.example.eglise.enums.TitulaireCompte;
import lombok.Data;

import java.util.List;

@Data
public class InscriptionFamilleRequest {
    private AdresseRequest adresse;
    private FamilleRequest famille;
    private PersonRequest pere;
    private PersonRequest mere;
    private MariageRequest mariage;
    private TitulaireCompte titulaireCompte;
    private List<PersonRequest> enfants;
}