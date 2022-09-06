package com.portfolio.backend.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.repository.PersonaRepo;

@Service
@Transactional
public class PersonaService implements IPersonaService {

    @Autowired
    PersonaRepo personaRepo;

    @Override
    public void deletePersona(int id) {
        personaRepo.deleteById(1);

    }

    @Override
    public Persona editarPersona(Persona nuevaPersona) {
        Persona persona = personaRepo.findById(1).orElse(null);
        persona.setNombre(nuevaPersona.getNombre());
        persona.setApellido(nuevaPersona.getApellido());
        persona.setImg(nuevaPersona.getImg());
        persona.setAbout(nuevaPersona.getAbout());
        persona.setTitulo(nuevaPersona.getTitulo());

        return persona;
    }

    @Override
    public void savePersona(Persona persona) {

        personaRepo.save(persona);

    }

    @Override
    public Persona traerPersona() {
        return personaRepo.getReferenceById(1);
    }

}