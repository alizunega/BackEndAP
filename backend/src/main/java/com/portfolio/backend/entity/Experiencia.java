package com.portfolio.backend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private Date fInicio;
    private Date fFin;
    
    public Experiencia() {
    }


    public Experiencia(String nombreE, String descripcionE, Date fInicio, Date fFin) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fInicio = fInicio;
        this.fFin = fFin;
    }
    

    
}
