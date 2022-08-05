package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoExperiencia {
    @NotBlank
    private String nombreExpe;
    @NotBlank
    private String descripcionExpe;
    @NotNull
    private String fechainicio;
    private String fechafin;


    public DtoExperiencia() {
    }


    public DtoExperiencia(@NotBlank String nombreExpe, @NotBlank String descripcionExpe, @NotNull String fechainicio,
            String fechafin) {
        this.nombreExpe = nombreExpe;
        this.descripcionExpe = descripcionExpe;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    
    
    
}
