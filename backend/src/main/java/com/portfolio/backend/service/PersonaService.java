package com.portfolio.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.repository.PersonaRepo;

@Service
@Transactional
public class PersonaService {
    @Autowired
    public final PersonaRepo personaRepo;
    //constructor
    public PersonaService(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }
    //CRUD
    public Persona addPersona(Persona persona){
        return personaRepo.save(persona);
    }
    public List<Persona> buscarPersonas(){
        return personaRepo.findAll();
    }
    
    public Persona buscarPorId(int id){
        return personaRepo.findById(id).orElse(null);
    }

    public Persona editarPersona(Persona persona){
        int id = 1;
        Persona perso = personaRepo.findById(id).orElse(null);
        perso.setNombre(persona.getNombre());
        perso.setApellido(persona.getApellido());
        perso.setImg(persona.getImg());
        perso.setAbout(persona.getAbout());
        perso.setTitulo(persona.getTitulo());

        return personaRepo.save(perso);
    }
    
    public void borrarPersona(int id){
        personaRepo.deleteById(id);
    }
    
    
}