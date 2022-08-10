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

import com.portfolio.backend.entity.Proyecto;
import com.portfolio.backend.service.ProyectoService;


@RequestMapping("/proyecto")
@RestController
public class ProyectoController {

    @Autowired
    public ProyectoService proyectoService;


    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> mostrarProyectos(){
        List<Proyecto> listaProyectos= proyectoService.buscarProyecto();
        return new ResponseEntity<>(listaProyectos, HttpStatus.OK);
    }
   
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<Proyecto> agregarProyecto(@RequestBody Proyecto proyecto){
        Proyecto proyectoNuevo = proyectoService.addProyecto(proyecto);
        return new ResponseEntity<Proyecto>(proyectoNuevo, HttpStatus.OK);
    }


    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public ResponseEntity<?> editarProyecto(@PathVariable int id, @RequestBody Proyecto proyecto){
        if(proyectoService.buscarPorId(id) == null){
            return new ResponseEntity<>("Proyecto no encontrado", HttpStatus.BAD_REQUEST);
        }
        Proyecto proyectoEditado = proyectoService.editarProyecto(id, proyecto);
        return new ResponseEntity<Proyecto>(proyectoEditado, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarProyecto(@PathVariable int id){
        
        if(proyectoService.buscarPorId(id) == null){
            return new ResponseEntity<>("Proyecto no encontrado", HttpStatus.BAD_REQUEST);
        }
        proyectoService.borrarProyecto(id);
        return new ResponseEntity<>("Proyecto borrado", HttpStatus.OK);
    }

}