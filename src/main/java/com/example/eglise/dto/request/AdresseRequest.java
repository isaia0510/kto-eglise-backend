package com.example.eglise.dto.request;

import lombok.Data;

@Data
public class AdresseRequest {
    private String lot;
    private String toerana;
    private String fokontany;
    private String commune;
    private String apv;
}