package com.portfolio.backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Proyecto;
import com.portfolio.backend.repository.ProyectoRepo;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    public final ProyectoRepo proyectoRepo;
    //contructor
    public ProyectoService(ProyectoRepo proyectoRepo) {
        this.proyectoRepo = proyectoRepo;
    }
    //CRUD
    public void save(Proyecto proyecto){
         proyectoRepo.save(proyecto);
    }
    public List<Proyecto> list(){
        return proyectoRepo.findAll();
    }
    
    public Optional<Proyecto> buscarPorId(int id){
        return proyectoRepo.findById(id);
    }
 
    public void delete(int id){
        proyectoRepo.deleteById(id);
    }
    
    
}