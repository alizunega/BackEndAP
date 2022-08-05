package com.portfolio.backend.service;

import java.util.List;

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
    public Skills addSkills(Skills skills){
        return skillsRepo.save(skills);
    }
    public List<Skills> buscarSkills(){
        return skillsRepo.findAll();
    }
    
    public Skills buscarPorId(int id){
        return skillsRepo.findById(id).orElse(null);
    }
    public Skills editarSkills(Skills skills){
        return skillsRepo.save(skills);
    }
    public void borrarSkills(int id){
        skillsRepo.deleteById(id);
    }
}