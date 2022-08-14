package com.portfolio.backend.service;

import java.util.List;
import java.util.Optional;

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
    public void save(Experiencia experiencia){
        experienciaRepo.save(experiencia);
    }
    
    public List<Experiencia> lista(){
        return experienciaRepo.findAll();
    }
    
    public Optional<Experiencia> buscarPorId(int id){
        return experienciaRepo.findById(id);
    }

    public void delete(int id){
        experienciaRepo.deleteById(id);
    }
    
}