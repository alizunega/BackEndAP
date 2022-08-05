package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.service.PersonaService;


@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    public PersonaService persoServ;

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> mostrarUsuario(@PathVariable("id") int id){
        Persona persona = persoServ.buscarPorId(id);
        if(persona == null){
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
   
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona perso){
        Persona persona = persoServ.addPersona(perso);
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }


    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public ResponseEntity<?> editar(@RequestBody Persona persona){
        Persona personaEditada = persoServ.editarPersona(persona);
        return new ResponseEntity<>(personaEditada, HttpStatus.OK);
    }

}