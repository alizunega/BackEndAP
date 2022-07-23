package com.portfolio.backend.security.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.portfolio.backend.security.enums.RolNombre;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter @Setter
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    
    
    public Rol() {
    }

    public Rol(@NonNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    
}