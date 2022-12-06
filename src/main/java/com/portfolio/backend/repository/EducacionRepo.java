package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.entity.Educacion;

@Repository
public interface EducacionRepo extends JpaRepository<Educacion, Integer> {

}