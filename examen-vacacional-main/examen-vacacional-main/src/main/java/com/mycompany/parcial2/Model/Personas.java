package com.mycompany.parcial2.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Personas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identification;
    
    @Column(name = "document_type")
    private String tipo_identificacion;
    private String name;
    private String status;
    private Double credit_value;
    
    
    public String toString() {
        return "(identification, document_type, name, status, credit_value) VALUES (" + identification + ", '" + tipo_identificacion
                + "', '" + name + "', '" + status + "', " + credit_value + ");";
    }
}
