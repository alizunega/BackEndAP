package com.portfolio.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.repository.IPersonaRepository;

@Service
public class ImpPersonaService implements  IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }

    @Override
    public Persona editarPersona(Long id, Persona pers) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        persona.setNombre(pers.getNombre());
        persona.setApellido(pers.getApellido());
        persona.setImg(pers.getImg());
        persona.setAbout(pers.getAbout());
        
        return  ipersonaRepository.save(persona);
        
    }
    
}