package com.portfolio.backend.entity;

import java.io.Serializable;

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
public class Educacion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String titulo;
    private String nombreInstitucion;
    private String fechainicio;
    private String fechafin;

    public Educacion() {
        
    }

    public Educacion(@NotNull String titulo, String nombreInstitucion, String fechainicio, String fechafin) {
        this.titulo = titulo;
        this.nombreInstitucion = nombreInstitucion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }
    
}
