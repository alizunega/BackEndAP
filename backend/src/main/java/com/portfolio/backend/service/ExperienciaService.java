package com.portfolio.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.repository.ExperienciaRepo;

@Service
@Transactional
public class ExperienciaService {

    @Autowired
    private final ExperienciaRepo experienciaRepo;
    //constructor
    public ExperienciaService(ExperienciaRepo experienciaRepo) {
        this.experienciaRepo = experienciaRepo;
    }

    //CRUD
    public Experiencia addExperiencia(Experiencia experiencia){
        return experienciaRepo.save(experiencia);
    }
    public List<Experiencia> buscarExperiencias(){
        return experienciaRepo.findAll();
    }
    
    public Experiencia buscarPorId(int id){
        return experienciaRepo.findById(id).orElse(null);
    }
    public Experiencia editarExperiencia(Experiencia experiencia){
        return experienciaRepo.save(experiencia);
    }
    public void borrarExperiencia(int id){
        experienciaRepo.deleteById(id);
    }
    
}