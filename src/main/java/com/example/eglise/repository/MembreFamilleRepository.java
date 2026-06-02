package com.example.eglise.repository;

import com.example.eglise.entity.MembreFamille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreFamilleRepository extends JpaRepository<MembreFamille, Long> {
}