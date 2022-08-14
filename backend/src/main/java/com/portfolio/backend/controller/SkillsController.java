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

import com.portfolio.backend.entity.Skills;
import com.portfolio.backend.service.SkillsService;

@RequestMapping("/skills")
@RestController
public class SkillsController {
    @Autowired public SkillsService skillsService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> mostrarSkills(){
        List<Skills> listaSkills = skillsService.list();
        return new ResponseEntity<>(listaSkills, HttpStatus.OK);
    }
   
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> agregarSkilll(@RequestBody Skills skills){
        skillsService.save(skills);
        return new ResponseEntity<>("Skill creada", HttpStatus.OK);
    }


    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarSkills(@PathVariable int id, @RequestBody Skills skills){
        if(skillsService.buscarPorId(id) == null){
            return new ResponseEntity<>("Skills no encontrada", HttpStatus.NOT_FOUND);
        }

        Skills nuevaSkills = skillsService.buscarPorId(id).get();
   
            nuevaSkills.setNombreSkill(skills.getNombreSkill());
            nuevaSkills.setPorcentaje(skills.getPorcentaje());
            nuevaSkills.setImgsrc(skills.getImgsrc());
            nuevaSkills.setColorInterno(skills.getColorInterno());
            nuevaSkills.setColorExterno(skills.getColorExterno());
             
            skillsService.save(nuevaSkills);

        return new ResponseEntity<>("Skills añadida", HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarSkills(@PathVariable int id){
        
        if(skillsService.buscarPorId(id) == null){
            return new ResponseEntity<>("Skill no encontrada", HttpStatus.BAD_REQUEST);
        }
        skillsService.delete(id);
        return new ResponseEntity<>("Skill borrada", HttpStatus.OK);
    }
    
}
