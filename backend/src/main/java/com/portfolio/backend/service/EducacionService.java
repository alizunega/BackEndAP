package com.portfolio.backend.service;

import java.util.List;
import java.util.Optional;

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
    public void save(Educacion educacion){
         educacionRepo.save(educacion);
    }

    public List<Educacion> lista(){
        return educacionRepo.findAll();
    }
    
    public Optional<Educacion> buscarPorId(int id){
        return educacionRepo.findById(id);
    }
    
    public void delete(int id){
         educacionRepo.deleteById(id);
    }

}