package com.portfolio.backend.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Skills implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nombreSkill;
    @NotNull
    private int porcentaje;
    private String imgsrc;
    private String colorInterno;
    private String colorExterno;

    public Skills() {
    }

    public Skills(@NotBlank String nombreSkill, @NotNull int porcentaje, String imgsrc, String colorInterno,
            String colorExterno) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
        this.imgsrc = imgsrc;
        this.colorInterno = colorInterno;
        this.colorExterno = colorExterno;
    }
    
    


}
