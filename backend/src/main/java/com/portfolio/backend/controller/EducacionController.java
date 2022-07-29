package com.portfolio.backend.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.dto.DtoEducacion;
import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.security.controller.Mensaje;
import com.portfolio.backend.service.SEducacion;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/educ")
@RestController
public class EducacionController {
    @Autowired
    SEducacion sEducacion;


    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id))
            return new ResponseEntity<>(new Mensaje("No existe esa educación"), HttpStatus.NOT_FOUND);

        Educacion educ = sEducacion.getOne(id).get();
        return new ResponseEntity<>(educ, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoeduc) {
        if (StringUtils.isBlank(dtoeduc.getTitulo()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), 
            HttpStatus.BAD_REQUEST);
        if (sEducacion.existsByTitulo(dtoeduc.getTitulo()))
            return new ResponseEntity<>(new Mensaje("Esa educación ya existe"), 
            HttpStatus.BAD_REQUEST);

        
        Educacion educacion = new Educacion(dtoeduc.getTitulo(), dtoeduc.getNombreInstitucion(), 
                                dtoeduc.getFInicio(), dtoeduc.getFFin());
            
        sEducacion.save(educacion);

        return new ResponseEntity<>(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoeduc) {

        // valida que exista el id buscado
        if (!sEducacion.existsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

        // valida si existe una educacion con ese titulo pero con distinto id
        if (sEducacion.existsByTitulo(dtoeduc.getTitulo())
                && sEducacion.getByTitulo(dtoeduc.getTitulo()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);

        // valida que no vengan campos vacios
        if (StringUtils.isBlank(dtoeduc.getTitulo()))
            return new ResponseEntity<>(new Mensaje("Este es campo obligatorio"), HttpStatus.BAD_REQUEST);

        // busca la unica experiencia segun el id
        Educacion educ = sEducacion.getOne(id).get();
        // setea nuevos valores
        educ.setTitulo(dtoeduc.getTitulo());
        educ.setNombreInstitucion(dtoeduc.getNombreInstitucion());
        educ.setFInicio(dtoeduc.getFInicio());
        educ.setFFin(dtoeduc.getFFin());
        // guarda
        sEducacion.save(educ);

        return new ResponseEntity<>(new Mensaje("Educación actualizada"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity<>(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity<>(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
}