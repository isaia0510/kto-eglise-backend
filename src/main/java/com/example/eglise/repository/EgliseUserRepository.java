package com.example.eglise.repository;

import com.example.eglise.entity.EgliseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EgliseUserRepository extends JpaRepository<EgliseUser, String> {
}
