package com.portfolio.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombreE;
    private String descripcionE;
    private String fInicio;
    private String fFin;
    
    public Experiencia() {
    }


    public Experiencia(String nombreE, String descripcionE, String fInicio, String fFin) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fInicio = fInicio;
        this.fFin = fFin;
    }
    

    
}
