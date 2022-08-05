package com.portfolio.backend.dto;

import java.sql.Blob;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoProyecto {
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String descripcionProyecto;
    private Blob imgproyecto;
    
    public DtoProyecto() {
    }

    public DtoProyecto(@NotBlank String nombreProyecto, @NotBlank String descripcionProyecto, Blob imgproyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.imgproyecto = imgproyecto;
    }
    

    
    
}