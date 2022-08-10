package com.portfolio.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.repository.EducacionRepo;

@Service
@Transactional
public class EducacionService {
    @Autowired
    private final EducacionRepo educacionRepo;
    //constructor
    public EducacionService(EducacionRepo educacionRepo) {
        this.educacionRepo = educacionRepo;
    }
    
    //CRUD
    public Educacion addEducacion(Educacion educacion){
        return educacionRepo.save(educacion);
    }
    public List<Educacion> buscarEducaciones(){
        return educacionRepo.findAll();
    }
    
    public Educacion buscarPorId(int id){
        return educacionRepo.findById(id).orElse(null);
    }
    public Educacion editarEducacion(int id, Educacion educacion){
        Educacion edu = educacionRepo.findById(id).orElse(null);

        edu.setTitulo(educacion.getTitulo());
        edu.setNombreInstitucion(educacion.getNombreInstitucion());
        edu.setFechainicio(educacion.getFechainicio());
        edu.setFechafin(educacion.getFechafin());
        
        return educacionRepo.save(edu);
    }

    public void borrarEducacion(int id){
         educacionRepo.deleteById(id);
    }

}