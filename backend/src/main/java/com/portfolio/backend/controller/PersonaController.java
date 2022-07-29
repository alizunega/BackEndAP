package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.service.IPersonaService;


@CrossOrigin(origins="http://localhost:4200/", maxAge = 3600)
@RestController
public class PersonaController {

    @Autowired
    public IPersonaService persoServ;

    @GetMapping("/persona/traer")
    @ResponseBody
    public List<Persona> getPersona(){
        return persoServ.getPersona();
    }

    @GetMapping("/persona/traer/perfil")
    public Persona findPersona(){
        return persoServ.findPersona((long)1);
    }
    
    @GetMapping("/persona/buscar/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable Long id){
        return persoServ.findPersona(id);
    }
   
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona pers){
        persoServ.savePersona(pers);
        return "La persona fue creada correctamente";
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/delete/{id}")
    public String deletePersona(@PathVariable Long id){
        persoServ.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido, 
                               @RequestParam("img") String nuevoImg, 
                               @RequestParam("about") String nuevoAbout)
                               {

        Persona persona = persoServ.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        persona.setAbout(nuevoAbout);

        persoServ.savePersona(persona);
        return persona;
    }

}