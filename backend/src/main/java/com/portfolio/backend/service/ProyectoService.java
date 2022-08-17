package com.portfolio.backend.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Proyecto;
import com.portfolio.backend.repository.ProyectoRepo;

@Service
@Transactional
public class ProyectoService implements IProyectoService{
    @Autowired
    ProyectoRepo proyectoRepo;

    @Override
    public void deleteProyecto(int id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        proyectoRepo.save(proyecto);
        
    }

    @Override
    public Proyecto traerProyectoPorId(int id) {
        Proyecto pro = proyectoRepo.findById(id).orElse(null);
        return pro;
    }

    @Override
    public List<Proyecto> traerProyectos() {
        List<Proyecto> proyectos = proyectoRepo.findAll();
        return proyectos;
    }
   
  
    
    
}