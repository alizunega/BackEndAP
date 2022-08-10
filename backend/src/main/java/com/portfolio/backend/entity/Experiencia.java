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
public class Experiencia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String nombreExpe;
    private String descripcionExpe;
    private String fechainicio;
    private String fechafin;
    
    public Experiencia() {
    }

    public Experiencia(@NotNull String nombreExpe, String descripcionExpe, String fechainicio, String fechafin) {
        this.nombreExpe = nombreExpe;
        this.descripcionExpe = descripcionExpe;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

}
