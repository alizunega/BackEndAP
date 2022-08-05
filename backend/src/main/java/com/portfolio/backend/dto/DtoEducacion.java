package com.portfolio.backend.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoEducacion {
    @NotBlank
    private String titulo;
    @NotBlank
    private String nombreInstitucion;
    @NotBlank
    private String fechainicio;
    private String fechafin;
    
    public DtoEducacion() {
    }

    public DtoEducacion(@NotBlank String titulo, @NotBlank String nombreInstitucion, @NotNull String fechainicio,
            String fechafin) {
        this.titulo = titulo;
        this.nombreInstitucion = nombreInstitucion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

   

}