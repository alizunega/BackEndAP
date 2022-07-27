package com.portfolio.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.entity.Experiencia;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    
    public Optional<Experiencia> findByNombreE(String nombreE);

    public boolean existsByNombreE(String nombreE);


    
}