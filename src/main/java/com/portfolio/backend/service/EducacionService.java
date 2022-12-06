package com.portfolio.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.repository.EducacionRepo;

@Service
@Transactional
public class EducacionService implements IEducacionService {
    @Autowired
    EducacionRepo educacionRepo;

    @Override
    public void deleteEducacion(int id) {
        educacionRepo.deleteById(id);
    }

    @Override
    public Educacion findEducacion(int id) {
        Educacion edu = educacionRepo.findById(id).orElse(null);
        return edu;
    }

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educaciones = educacionRepo.findAll();
        return educaciones;
    }

    @Override
    public void saveEducacion(Educacion educacion) {

        educacionRepo.save(educacion);

    }

}