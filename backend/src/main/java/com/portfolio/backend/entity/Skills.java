package com.portfolio.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nombreSkill;
    @NotNull
    @Range(min = 1, max = 100)
    private int porcentaje;
    private String imgsrc;
    private String colorInterno;
    private String colorExterno;

    public Skills() {
    }

    public Skills(@NotBlank String nombreSkill, @NotNull @Range(min = 1, max = 100) int porcentaje, String imgsrc,
            String colorInterno, String colorExterno) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
        this.imgsrc = imgsrc;
        this.colorInterno = colorInterno;
        this.colorExterno = colorExterno;
    }

}
