package com.example.eglise.repository;

import com.example.eglise.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, String> {
}
