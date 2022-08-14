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
import com.portfolio.backend.service.EducacionService;

@CrossOrigin()
@RequestMapping("/educacion")
@RestController
public class EducacionController {

    @Autowired
    public EducacionService educacionServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> lista(){
        List<Educacion> listaEducacion = educacionServ.lista();
        return new ResponseEntity<>(listaEducacion, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        Educacion educacion = educacionServ.buscarPorId(id).get();
        if(educacion == null){
            return new ResponseEntity<>("Educacion no encontrada", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(educacion,HttpStatus.OK);
    }
   
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> addEducacion(@RequestBody Educacion educacion){
        educacionServ.save(educacion);
        return new ResponseEntity<>("Educación creada",HttpStatus.OK);
    }


    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarEducacion(@PathVariable int id, @RequestBody Educacion educacion){

        if(educacionServ.buscarPorId(id) == null){
            return new ResponseEntity<>("Educación no encontrada", HttpStatus.BAD_REQUEST);
        }

        Educacion educacionEditada = educacionServ.buscarPorId(id).get();
       
        educacionEditada.setTitulo(educacion.getTitulo());
        educacionEditada.setNombreInstitucion(educacion.getNombreInstitucion());
        educacionEditada.setFechainicio(educacion.getFechainicio());
        educacionEditada.setFechafin(educacion.getFechafin());
            
        educacionServ.save(educacionEditada);

        return new ResponseEntity<>("Educación actualizada", HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        
        if(educacionServ.buscarPorId(id) == null){
            return new ResponseEntity<>("Educacion no encontrada", HttpStatus.BAD_REQUEST);
        }
        educacionServ.delete(id);
        return new ResponseEntity<>("Educacion borrada", HttpStatus.OK);
    }
   
    
}
