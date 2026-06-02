package com.example.eglise.repository;

import com.example.eglise.entity.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleRepository extends JpaRepository<Famille, String> {
}
