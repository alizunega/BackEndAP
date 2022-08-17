package com.portfolio.backend.service;

import com.portfolio.backend.entity.Persona;

public interface IPersonaService {

    public Persona traerPersona();
    public void savePersona(Persona persona);
    public void deletePersona(int id);
    public Persona editarPersona(Persona persona);
    
}