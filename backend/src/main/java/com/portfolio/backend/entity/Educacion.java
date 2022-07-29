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
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String titulo;
    private String nombreInstitucion;
    private String fInicio;
    private String fFin;

    public Educacion() {
        
    }
    
    public Educacion(String titulo, String nombreInstitucion, String fInicio, String fFin) {
        this.titulo = titulo;
        this.nombreInstitucion = nombreInstitucion;
        this.fInicio = fInicio;
        this.fFin = fFin;
    }

    
}
