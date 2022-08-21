package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.entity.Proyecto;
import com.portfolio.backend.service.IProyectoService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("proyecto")
@RestController
public class ProyectoController {

    @Autowired
    public IProyectoService iProyectoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> lista() {
        List<Proyecto> listaProyectos = iProyectoService.traerProyectos();
        return new ResponseEntity<>(listaProyectos, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> addProyecto(@RequestBody Proyecto proyecto) {
        iProyectoService.saveProyecto(proyecto);
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> mostrarProyecto(@PathVariable int id) {

        Proyecto proyecto = iProyectoService.traerProyectoPorId(id);
        if (proyecto == null) {
            return new ResponseEntity<>("Proyecto no encontrado", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarProyecto(@PathVariable int id, @RequestBody Proyecto proyecto) {
        if (iProyectoService.traerProyectoPorId(id) == null) {
            return new ResponseEntity<>("Proyecto no encontrado", HttpStatus.BAD_REQUEST);
        }

        Proyecto proyectoNuevo = iProyectoService.traerProyectoPorId(id);

        proyectoNuevo.setNombreProyecto(proyecto.getNombreProyecto());
        proyectoNuevo.setDescripcionProyecto(proyecto.getDescripcionProyecto());
        proyectoNuevo.setImgproyecto(proyecto.getImgproyecto());
        proyectoNuevo.setLinkproyecto(proyecto.getLinkproyecto());

        iProyectoService.saveProyecto(proyectoNuevo);

        return new ResponseEntity<>(proyectoNuevo, HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarProyecto(@PathVariable int id) {

        if (iProyectoService.traerProyectoPorId(id) == null) {
            return new ResponseEntity<>("Proyecto no encontrado", HttpStatus.BAD_REQUEST);
        }
        iProyectoService.deleteProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}