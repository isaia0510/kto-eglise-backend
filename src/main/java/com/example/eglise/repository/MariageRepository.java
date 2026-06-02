package com.example.eglise.repository;

import com.example.eglise.entity.Mariage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MariageRepository extends JpaRepository<Mariage, String> {
}
