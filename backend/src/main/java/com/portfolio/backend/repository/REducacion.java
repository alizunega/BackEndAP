package com.portfolio.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.entity.Educacion;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer> {
    
    public Optional<Educacion> findByTitulo(String titulo);

    public boolean existsByTitulo(String titulo);
    
}