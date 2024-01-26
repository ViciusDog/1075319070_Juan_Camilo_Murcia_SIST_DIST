package com.Corhuila.Corhuila.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/*
- id: BIGINT (primary key, auto-incremental)
- name: VARCHAR(50)
- description: TEXT
* */
@Entity
@Table(name = "product_1075319070")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime created_at;

    @Column(name = "update_at", nullable = true)
    private LocalDateTime update_at;

    @Column(name = "delete_at", nullable = true)
    private LocalDateTime delete_at;
}
