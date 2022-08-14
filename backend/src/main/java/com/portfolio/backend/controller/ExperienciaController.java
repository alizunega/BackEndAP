package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.service.ExperienciaService;

@RequestMapping("/experiencia")
@RestController
public class ExperienciaController {

    @Autowired
    public ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> listaExpe = experienciaService.lista();
        return new ResponseEntity<>(listaExpe, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> mostrarExperiencia(@PathVariable int id) {

        Experiencia expe = experienciaService.buscarPorId(id).get();
        if (expe == null) {
            return new ResponseEntity<>("Experiencia no encontrada", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(expe, HttpStatus.OK);
    }

    // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> agregarExperiencia(@RequestBody Experiencia expe) {
        experienciaService.save(expe);
        return new ResponseEntity<>("Experiencia añadida", HttpStatus.OK);
    }

    // @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarExperiencia(@PathVariable int id, @RequestBody Experiencia experiencia) {
        if (experienciaService.buscarPorId(id) == null) {
            return new ResponseEntity<>("Experiencia no encontrada", HttpStatus.BAD_REQUEST);
        }

        Experiencia experienciaEditada = experienciaService.buscarPorId(id).get();

        experienciaEditada.setNombreExpe(experiencia.getNombreExpe());
        experienciaEditada.setDescripcionExpe(experiencia.getDescripcionExpe());
        experienciaEditada.setFechainicio(experiencia.getFechainicio());
        experienciaEditada.setFechafin(experiencia.getFechafin());
        experienciaService.save(experienciaEditada);

        return new ResponseEntity<>("Experiencia editada", HttpStatus.OK);
    }

    // @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable int id) {

        if (experienciaService.buscarPorId(id) == null) {
            return new ResponseEntity<>("Experiencia no encontrada", HttpStatus.BAD_REQUEST);
        }
        experienciaService.delete(id);
        return new ResponseEntity<>("Experiencia borrada", HttpStatus.OK);
    }

}