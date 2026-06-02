package com.example.eglise.repository;

import com.example.eglise.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, String> {
}
