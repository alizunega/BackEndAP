package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String fInicio;
    private String fFin;


    public DtoExperiencia() {
    }

    public DtoExperiencia(@NotBlank String nombreE, 
                        @NotBlank String descripcionE, 
                        @NotBlank String fInicio, String fFin) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fInicio = fInicio;
        this.fFin = fFin;

    }
    
    
}
