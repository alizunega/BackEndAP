package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.backend.entity.Proyecto;

public interface ProyectoRepo extends JpaRepository<Proyecto, Integer> {

}