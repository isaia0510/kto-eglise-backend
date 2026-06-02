package com.example.eglise.controllers;

import com.example.eglise.entity.*;
import com.example.eglise.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/util")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UtilController {
    private final SakrametaRepository sakrametaRepository;
    private final FikambananaRepository fikambananaRepository;
    private final VaomieraRepository vaomieraRepository;
    private final GenreRepository genreRepository;
    private final MaritalStatusRepository maritalStatusRepository;

    @GetMapping("/genre")
    public ResponseEntity<List<Genre>> getGenre() {
        return ResponseEntity.ok(genreRepository.findAll());
    }

    @GetMapping("/marital")
    public ResponseEntity<List<MaritalStatus>> getMarital() {
        return ResponseEntity.ok(maritalStatusRepository.findAll());
    }

    @GetMapping("/sakrameta")
    public ResponseEntity<List<Sakrameta>> getSakrameta() {
        return ResponseEntity.ok(sakrametaRepository.findAll());
    }

    @GetMapping("/fikambanana")
    public ResponseEntity<List<Fikambanana>> getFikambanana() {
        return ResponseEntity.ok(fikambananaRepository.findAll());
    }

    @GetMapping("/vaomiera")
    public ResponseEntity<List<Vaomiera>> getVaomiera() {
        return ResponseEntity.ok(vaomieraRepository.findAll());
    }
}
