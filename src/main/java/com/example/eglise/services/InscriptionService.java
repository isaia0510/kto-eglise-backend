package com.example.eglise.services;

import com.example.eglise.dto.request.InscriptionFamilleRequest;

public interface InscriptionService {
    void inscrire(InscriptionFamilleRequest request);
}
