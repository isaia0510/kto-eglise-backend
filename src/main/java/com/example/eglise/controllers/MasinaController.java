package com.example.eglise.controllers;

import com.example.eglise.entity.Fikambanana;
import com.example.eglise.entity.Sakrameta;
import com.example.eglise.entity.Vaomiera;
import com.example.eglise.repository.FikambananaRepository;
import com.example.eglise.repository.SakrametaRepository;
import com.example.eglise.repository.VaomieraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/masina")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MasinaController {
    private final SakrametaRepository sakrametaRepository;
    private final FikambananaRepository fikambananaRepository;
    private final VaomieraRepository vaomieraRepository;

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
