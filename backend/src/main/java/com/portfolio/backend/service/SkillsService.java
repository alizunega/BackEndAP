package com.portfolio.backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Skills;
import com.portfolio.backend.repository.SkillsRepo;

@Service
@Transactional
public class SkillsService {
    @Autowired
    public final SkillsRepo skillsRepo;
    //constructor
    public SkillsService(SkillsRepo skillsRepo) {
        this.skillsRepo = skillsRepo;
    }
    //CRUD
    public void save(Skills skills){
        skillsRepo.save(skills);
    }
    public List<Skills> list(){
        return skillsRepo.findAll();
    }
    
    public Optional<Skills> buscarPorId(int id){
        return skillsRepo.findById(id);
    }

    public void delete(int id){
        skillsRepo.deleteById(id);
    }
}