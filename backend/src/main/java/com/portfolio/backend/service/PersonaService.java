package com.portfolio.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.repository.PersonaRepository;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    public PersonaRepository persoRepo;

    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();

    }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);

    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);

    }

    @Override
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }

    @Override
    public void editarPersona(Long id, Persona per) {
        Persona persona = buscarPersona(id);
        if (persona != null) {
            persona.setNombre(per.getNombre());
            persona.setApellido(per.getApellido());
            persona.setImg(per.getImg());
            persona.setAbout(per.getAbout());

            persoRepo.save(persona);

        }
    }

}