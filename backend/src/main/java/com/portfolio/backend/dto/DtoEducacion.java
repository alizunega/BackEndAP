package com.portfolio.backend.dto;


import javax.validation.constraints.NotBlank;

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
    private String fInicio;
    private String fFin;
    
    public DtoEducacion() {
    }

    public DtoEducacion(@NotBlank String titulo, @NotBlank String nombreInstitucion, 
                        @NotBlank String fInicio, String fFin) {
        this.titulo = titulo;
        this.nombreInstitucion = nombreInstitucion;
        this.fInicio = fInicio;
        this.fFin = fFin;
    }

}