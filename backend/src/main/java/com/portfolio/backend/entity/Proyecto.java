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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String descripcionProyecto;
    private String imgproyecto;
    private String linkproyecto;

    public Proyecto() {
    }

    public Proyecto(@NotBlank String nombreProyecto, @NotBlank String descripcionProyecto, String imgproyecto,
            String linkproyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.imgproyecto = imgproyecto;
        this.linkproyecto = linkproyecto;
    }
}
