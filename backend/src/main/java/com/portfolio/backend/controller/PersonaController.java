package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.service.IPersonaService;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class PersonaController {

    @Autowired
    public IPersonaService persoServ;
   

    @PostMapping("/persona/crear")
    public void agregarPersona(@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }

    @GetMapping("/persona/traer")
    @ResponseBody
    public List<Persona> verPersonas(){
        return persoServ.verPersonas();
    }

    @DeleteMapping("/persona/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);

    }

    @GetMapping("/persona/buscar/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable Long id){
        return persoServ.buscarPersona(id);
    }

    @PutMapping("/persona/editar/{id}")
    public void editarPersona(@PathVariable Long id, @RequestBody Persona pers){
        persoServ.editarPersona(id, pers);
    }

}