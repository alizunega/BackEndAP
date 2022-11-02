package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.backend.entity.Skills;

public interface SkillsRepo extends JpaRepository<Skills, Integer> {

}