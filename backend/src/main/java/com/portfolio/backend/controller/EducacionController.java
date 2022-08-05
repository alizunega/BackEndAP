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

import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.service.EducacionService;

@RequestMapping("/educacion")
@RestController
public class EducacionController {

    @Autowired
    public EducacionService educacionServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> mostrarEducaciones(){
        List<Educacion> listaEducacion = educacionServ.buscarEducaciones();
        return new ResponseEntity<>(listaEducacion, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> mostrarEducacion(@PathVariable("id") int id){
        Educacion educacion = educacionServ.buscarPorId(id);
        if(educacion == null){
            return new ResponseEntity<>("Educacion no encontrada", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(educacion,HttpStatus.OK);
    }
   
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<Educacion> agregarEducacion(@RequestBody Educacion educacion){
        Educacion educacionNueva = educacionServ.addEducacion(educacion);
        return new ResponseEntity<Educacion>(educacionNueva, HttpStatus.OK);
    }


    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion){
        Educacion educacionEditada = educacionServ.editarEducacion(educacion);
        return new ResponseEntity<Educacion>(educacionEditada, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarEducacion(@PathVariable("id") int id){
        
        if(educacionServ.buscarPorId(id) == null){
            return new ResponseEntity<>("Educacion no encontrada", HttpStatus.BAD_REQUEST);
        }
        educacionServ.borrarEducacion(id);
        return new ResponseEntity<>("Educacion borrada", HttpStatus.OK);
    }
   
    
}
