package com.portfolio.backend.controller;

import java.util.List;

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

import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.service.IEducacionService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("educacion")
@RestController
public class EducacionController {

    @Autowired
    public IEducacionService iEducacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> lista(){
        List<Educacion> listaEducacion = iEducacionService.getEducacion();
        return new ResponseEntity<>(listaEducacion, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        Educacion educacion = iEducacionService.findEducacion(id);
        if(educacion == null){
            return new ResponseEntity<>("Educacion no encontrada", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(educacion,HttpStatus.OK);
    }
   
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> addEducacion(@RequestBody Educacion educacion){
        iEducacionService.saveEducacion(educacion);
        return new ResponseEntity<>("Educación creada",HttpStatus.OK);
    }


    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarEducacion(@PathVariable int id, @RequestBody Educacion educacion){
        
        Educacion educacionEditada = iEducacionService.findEducacion(id);

        if(educacionEditada == null){
            return new ResponseEntity<>("Educación no encontrada", HttpStatus.BAD_REQUEST);
        }

        educacionEditada.setTitulo(educacion.getTitulo());
        educacionEditada.setNombreInstitucion(educacion.getNombreInstitucion());
        educacionEditada.setFechainicio(educacion.getFechainicio());
        educacionEditada.setFechafin(educacion.getFechafin());

        iEducacionService.saveEducacion(educacionEditada);
        return new ResponseEntity<>("Educación actualizada", HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        
        if(iEducacionService.findEducacion(id) == null){
            return new ResponseEntity<>("Educacion no encontrada", HttpStatus.BAD_REQUEST);
        }
        iEducacionService.deleteEducacion(id);
        return new ResponseEntity<>("Educacion borrada", HttpStatus.OK);
    }
   
    
}
