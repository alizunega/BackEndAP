package com.portfolio.backend.service;

import java.util.List;

import com.portfolio.backend.entity.Skills;

public interface ISkillsService {

    public void saveSkills(Skills skills);

    public void deleteSkills(int id);

    public List<Skills> traerSkills();

    public Skills traerSkillsPorId(int id);

}