package com.example.eglise.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PersonRequest {
    private String anarana;

    private String fanampiny;

    private LocalDate dateNaissance;

    private String telephone;

    private String email;

    private String metier;

    private String nomPere;

    private String nomMere;

    private Boolean estMort;

    private String genreId;

    private List<String> sakrametaIds;

    private List<String> fikambananaIds;

    private List<String> vaomieraIds;

}
