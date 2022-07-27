package com.portfolio.backend.service;


import java.util.List;

import com.portfolio.backend.entity.Persona;

public interface IPersonaService {
    //Traer una lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deletePersona(Long id);
    
    //Buscar una persona por ID
    public Persona findPersona(Long id);
    
    //Editar persona segun id
    public Persona editarPersona(Long id, Persona persona);
}