package com.Corhuila.Corhuila.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Table(name = "customer_1075319070")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime created_at;

    @Column(name = "update_at", nullable = true)
    private LocalDateTime update_at;

    @Column(name = "delete_at", nullable = true)
    private LocalDateTime delete_at;
}
