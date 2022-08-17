package com.portfolio.backend.service;

import java.util.List;


import com.portfolio.backend.entity.Experiencia;

public interface IExperienciaService {

    public List<Experiencia> getExperiencia();
    public void saveExperiencia(Experiencia experiencia);
    public void deleteExperiencia(int id);
    public Experiencia findExperiencia(int id);
    
}