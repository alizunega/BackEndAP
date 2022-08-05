package com.portfolio.backend.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyecto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String descripcionProyecto;
    private String imgproyecto;

    
    public Proyecto() {
    }


    public Proyecto(@NotBlank String nombreProyecto, @NotBlank String descripcionProyecto, String imgproyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.imgproyecto = imgproyecto;
    }
}

