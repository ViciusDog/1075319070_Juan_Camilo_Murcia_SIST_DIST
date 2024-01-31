package com.project.project.service.repositories;
import com.project.project.model.Resumen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResumenRepository extends JpaRepository<Resumen, Integer> {
}
