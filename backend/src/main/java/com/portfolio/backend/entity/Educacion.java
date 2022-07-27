package com.portfolio.backend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Educacion {
    @Id
    @NotNull
    private Long id;
    private String titulo;
    private String nombreInstitucion;
    private Date fInicio;
    private Date fFin;
    
    public Educacion(@NotNull Long id, String titulo, String nombreInstitucion, Date fInicio, Date fFin) {
        this.id = id;
        this.titulo = titulo;
        this.nombreInstitucion = nombreInstitucion;
        this.fInicio = fInicio;
        this.fFin = fFin;
    }

    public Educacion() {
    }
    
}
