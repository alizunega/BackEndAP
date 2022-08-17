package com.portfolio.backend.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@Entity
public class Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min=1,max=50,message = "no cumple")
    private String nombre;
    @NotNull
    @Size(min=1,max=50,message = "no cumple")
    private String apellido;
    private String img;
    @Size(min=1,max=1000,message = "no cumple")
    private String about;
    private String titulo;
    
    public Persona() {
    }

    public Persona(@NotNull String nombre, @NotNull String apellido, String img, String about, String titulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.about = about;
        this.titulo = titulo;
    }


}
