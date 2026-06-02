package com.example.eglise.controllers;

import com.example.eglise.dto.request.InscriptionFamilleRequest;
import com.example.eglise.services.InscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inscriptions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InscriptionController {
    private final InscriptionService inscriptionService;

    @PostMapping
    public ResponseEntity<String> inscrire(@RequestBody InscriptionFamilleRequest request) {
        inscriptionService.inscrire(request);
        return ResponseEntity.ok("Inscription réussie");
    }
}