package com.project.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "estadisticas")
@Data
public class Resumen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_id")
    private Integer id;

    private Date created_at;
    private Double utilities;
    private Double saves;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false, updatable = false)
    private Person persona;
}
