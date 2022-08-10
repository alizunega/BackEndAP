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
    public ResponseEntity<List<Experiencia>> mostrarExperiencias(){
        List<Experiencia> listaExpe = experienciaService.buscarExperiencias();
        return new ResponseEntity<>(listaExpe, HttpStatus.OK);
    }
   
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<Experiencia> agregarExperiencia(@RequestBody Experiencia expe){
        Experiencia experienciaNueva = experienciaService.addExperiencia(expe);
        return new ResponseEntity<Experiencia>(experienciaNueva, HttpStatus.OK);
    }


    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public ResponseEntity<?> editarExperiencia(@PathVariable int id, @RequestBody Experiencia expe){
        if(experienciaService.buscarPorId(id) == null){
            return new ResponseEntity<>("Experiencia no encontrada", HttpStatus.BAD_REQUEST);
        }
        Experiencia experienciaEditada = experienciaService.editarExperiencia(id, expe);
        return new ResponseEntity<Experiencia>(experienciaEditada, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable int id){
        
        if(experienciaService.buscarPorId(id) == null){
            return new ResponseEntity<>("Experiencia no encontrada", HttpStatus.BAD_REQUEST);
        }
        experienciaService.borrarExperiencia(id);
        return new ResponseEntity<>("Experiencia borrada", HttpStatus.OK);
    }


}