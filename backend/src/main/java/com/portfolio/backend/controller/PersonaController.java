package com.portfolio.backend.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.service.IPersonaService;

@CrossOrigin(origins = "https://portfolioap-2022.web.app")
@RestController
@RequestMapping("persona")
public class PersonaController {

    @Autowired
    public IPersonaService iPersonaService;

    @GetMapping("/traer")
    public ResponseEntity<?> mostrarUsuario() {
        Persona persona = iPersonaService.traerPersona();
        if (persona == null) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> agregarPersona(@RequestBody Persona perso) {
        if (StringUtils.isBlank(perso.getNombre())
                && StringUtils.isBlank(perso.getApellido())
                && StringUtils.isBlank(perso.getAbout())
                && StringUtils.isBlank(perso.getTitulo())) {
            return new ResponseEntity<>("Campos obligatorios vacios", HttpStatus.BAD_REQUEST);
        }
        iPersonaService.savePersona(perso);
        return new ResponseEntity<>("Persona creada exitosamente", HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editar(@RequestBody Persona persona) {
        if (StringUtils.isBlank(persona.getNombre())
                && StringUtils.isBlank(persona.getApellido())
                && StringUtils.isBlank(persona.getAbout())
                && StringUtils.isBlank(persona.getTitulo())) {
            return new ResponseEntity<>("Campos obligatorios vacios", HttpStatus.BAD_REQUEST);
        }
        Persona personaEditada = iPersonaService.editarPersona(persona);
        return new ResponseEntity<>(personaEditada, HttpStatus.OK);
    }

}