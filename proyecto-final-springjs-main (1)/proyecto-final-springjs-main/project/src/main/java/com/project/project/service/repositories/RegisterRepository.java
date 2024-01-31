package com.project.project.service.repositories;

import com.project.project.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Registro, Integer> {
}
