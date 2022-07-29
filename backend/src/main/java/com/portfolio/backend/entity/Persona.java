package com.portfolio.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=1,max=50,message = "no cumple")
    private String nombre;
    @NotNull
    @Size(min=1,max=50,message = "no cumple")
    private String apellido;
    private String img;
    private String about;


    public Persona(Long id, String nombre, String apellido, String img, String about) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.about = about;
    }

    public Persona(){

    }

}
