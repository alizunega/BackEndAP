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

import com.portfolio.backend.dto.DtoExperiencia;
import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.security.controller.Mensaje;
import com.portfolio.backend.service.SExperiencia;

@RestController

@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200/")
public class ExperienciaController {
    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        Experiencia expe = sExperiencia.getOne(id).get();
        return new ResponseEntity<>(expe, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (sExperiencia.existsByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity<>(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);

        Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE(), dtoexp.getFInicio(),
                dtoexp.getFFin());
        sExperiencia.save(experiencia);

        return new ResponseEntity<>(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExpe) {

        // valida que exista el id buscado
        if (!sExperiencia.existsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

        // valida si existe una experiencia con ese nombre pero con distinto id
        if (sExperiencia.existsByNombreE(dtoExpe.getNombreE())
                && sExperiencia.getByNombreE(dtoExpe.getNombreE()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);

        // valida que no vengan campos vacios
        if (StringUtils.isBlank(dtoExpe.getNombreE()))
            return new ResponseEntity<>(new Mensaje("El nombre es campo obligatorio"), HttpStatus.BAD_REQUEST);

        // busca la unica experiencia segun el id
        Experiencia expe = sExperiencia.getOne(id).get();
        // setea nuevos valores
        expe.setNombreE(dtoExpe.getNombreE());
        expe.setDescripcionE(dtoExpe.getDescripcionE());
        expe.setFInicio(dtoExpe.getFInicio());
        expe.setFFin(dtoExpe.getFFin());
        // guarda
        sExperiencia.save(expe);

        return new ResponseEntity<>(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // valida que exista el id buscado
        if (!sExperiencia.existsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

        sExperiencia.delete(id);
        return new ResponseEntity<>(new Mensaje("Experiencia eliminada"), HttpStatus.OK);

    }

}