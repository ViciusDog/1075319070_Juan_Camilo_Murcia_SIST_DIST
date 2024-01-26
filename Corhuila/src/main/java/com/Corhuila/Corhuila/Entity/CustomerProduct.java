package com.Corhuila.Corhuila.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer_product_1075319070")
@Data
/*
- id: BIGINT (primary key, auto-incremental)
- customer_id: BIGINT (foreign key)
- product_id: BIGINT (foreign key, unique constraint)
- balance: DECIMAL(10,2)
 */
public class CustomerProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer customer_id;
    private Integer product_id;

    @Column(name = "balance", nullable = false)
    private Double balance;
    private Boolean status;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime created_at;

    @Column(name = "update_at", nullable = true)
    private LocalDateTime update_at;

    @Column(name = "delete_at", nullable = true)
    private LocalDateTime delete_at;
}
