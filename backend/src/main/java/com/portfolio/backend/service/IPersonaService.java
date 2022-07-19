package com.portfolio.backend.service;

import java.util.List;

import com.portfolio.backend.entity.Persona;

public interface IPersonaService {

    public List<Persona> verPersonas();
    public void crearPersona(Persona pers);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public void editarPersona(Long id, Persona pers);    
    
}