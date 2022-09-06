package com.portfolio.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.repository.ExperienciaRepo;

@Transactional
@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    ExperienciaRepo experienciaRepo;

    @Override
    public void deleteExperiencia(int id) {
        experienciaRepo.deleteById(id);

    }

    @Override
    public Experiencia findExperiencia(int id) {
        Experiencia expe = experienciaRepo.findById(id).orElse(null);
        return expe;
    }

    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> experiencias = experienciaRepo.findAll();
        return experiencias;
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {

        experienciaRepo.save(experiencia);

    }

}