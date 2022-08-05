package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSkills {

    @NotBlank
    private String nombreSkill;
    @NotNull
    private float porcentaje;
    private String imgsrc;
    private String colorInterno;
    private String colorExterno;

    public DtoSkills() {
    }

    public DtoSkills(String nombreSkill, float porcentaje, String imgsrc, String colorInterno,
            String colorExterno) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
        this.imgsrc = imgsrc;
        this.colorInterno = colorInterno;
        this.colorExterno = colorExterno;
    }

}