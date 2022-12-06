package com.portfolio.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String nombreInstitucion;
    @NotBlank
    private String fechainicio;
    private String fechafin;

    public Educacion() {

    }

    public Educacion(@NotBlank String titulo, @NotBlank String nombreInstitucion, @NotBlank String fechainicio,
            String fechafin) {
        this.titulo = titulo;
        this.nombreInstitucion = nombreInstitucion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

}
