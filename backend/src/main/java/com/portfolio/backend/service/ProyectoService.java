package com.portfolio.backend.service;

import java.util.List;

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
    public Proyecto addProyecto(Proyecto proyecto){
        return proyectoRepo.save(proyecto);
    }
    public List<Proyecto> buscarProyecto(){
        return proyectoRepo.findAll();
    }
    
    public Proyecto buscarPorId(int id){
        return proyectoRepo.findById(id).orElse(null);
    }
    public Proyecto editarProyecto(Proyecto proyecto){
        return proyectoRepo.save(proyecto);
    }
    public void borrarProyecto(int id){
        proyectoRepo.deleteById(id);
    }
    
    
}