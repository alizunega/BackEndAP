package com.portfolio.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Skills;
import com.portfolio.backend.repository.SkillsRepo;

@Service
@Transactional
public class SkillsService implements ISkillsService{
    @Autowired
    SkillsRepo skillsRepo;

    @Override
    public void deleteSkills(int id) {
        skillsRepo.deleteById(id);
    }

    @Override
    public void saveSkills(Skills skill) {
        skillsRepo.save(skill);   
    }

    @Override
    public List<Skills> traerSkills() {
        List<Skills> skills = skillsRepo.findAll();
        return skills;
    }

    @Override
    public Skills traerSkillsPorId(int id) {
        Skills skill = skillsRepo.findById(id).orElse(null);
        return skill;
    }

    
   
}