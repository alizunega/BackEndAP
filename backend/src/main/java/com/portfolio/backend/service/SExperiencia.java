package com.portfolio.backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.repository.RExperiencia;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;

    //trae una lista de todas las experiencias
    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }

    //trae una experiencia segun id
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }

    //trae una experiencia segun nombreE
    public Optional<Experiencia> getByNombreE(String nombreE){
        return rExperiencia.findByNombreE(nombreE);
    }
    //guarda experiencia
    public void save(Experiencia expe){
        rExperiencia.save(expe);
    }

    //borrar experiencia segun id
    public void delete(int id){
        rExperiencia.deleteById(id);

    }

    //booleano indica si existe experiencia segun id
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }

    //booleano indica si existe experiencia segun nombre
    public boolean existsByNombreE(String nombreE){
        return rExperiencia.existsByNombreE(nombreE);
    }
    
}