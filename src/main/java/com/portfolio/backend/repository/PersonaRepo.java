package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.portfolio.backend.entity.Persona;


public interface PersonaRepo extends JpaRepository<Persona, Integer> {

}