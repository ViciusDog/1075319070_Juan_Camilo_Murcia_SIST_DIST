package com.project.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "actualizations")
@Data
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double earns;
    private Double spends;
    private Date created_at;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false, updatable = false)
    private Person persona;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL , mappedBy = "record", orphanRemoval = true)
    private List<Comment> comentarios;
}
