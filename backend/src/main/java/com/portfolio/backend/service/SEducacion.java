package com.portfolio.backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.repository.REducacion;

@Service
@Transactional
public class SEducacion {
    @Autowired
    REducacion rEducacion;
        //trae una lista de educacion
        public List<Educacion> list(){
            return rEducacion.findAll();
        }
    
        //trae una educacion segun id
        public Optional<Educacion> getOne(int id){
            return rEducacion.findById(id);
        }
    
        //trae una educacion segun titulo
        public Optional<Educacion> getByTitulo(String titulo){
            return rEducacion.findByTitulo(titulo);
        }
        //guarda educacion
        public void save(Educacion educ){
            rEducacion.save(educ);
        }
    
        //borrar educacion segun id
        public void delete(int id){
            rEducacion.deleteById(id);
    
        }
    
        //booleano indica si existe educacion segun id
        public boolean existsById(int id){
            return rEducacion.existsById(id);
        }
    
        //booleano indica si existe educacion segun titulo
        public boolean existsByTitulo(String titulo){
            return rEducacion.existsByTitulo(titulo);
        }
        
    
}