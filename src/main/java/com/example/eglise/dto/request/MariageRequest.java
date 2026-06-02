package com.example.eglise.dto.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MariageRequest {
    private LocalDate dateReligieux;

    private LocalDate dateCivil;

    private Boolean catholic;

    private String churchName;

    private Boolean divorce;
}
