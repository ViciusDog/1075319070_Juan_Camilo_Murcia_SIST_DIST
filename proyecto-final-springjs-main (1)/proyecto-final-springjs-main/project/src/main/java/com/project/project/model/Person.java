package com.project.project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "personas")
@Data
public class Person {
    @Id
    private Integer identification;

    @Column(name = "document_type")
    private String doc_type;

    private String names;
    private String surname;
    private String working_on;
    private String email;
    private String saves_percent;
    private Date birthday;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL , mappedBy = "persona")
    private List<Registro> registros;


    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL , mappedBy = "persona")
    private List<Resumen> estadisticas;

}
