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

import com.portfolio.backend.entity.Skills;
import com.portfolio.backend.service.ISkillsService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("skills")
@RestController
public class SkillsController {

    @Autowired
    public ISkillsService iSkillsService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> mostrarSkills() {
        List<Skills> listaSkills = iSkillsService.traerSkills();
        return new ResponseEntity<>(listaSkills, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> mostrarSkillporId(@PathVariable int id) {

        Skills skill = iSkillsService.traerSkillsPorId(id);
        if (skill == null) {
            return new ResponseEntity<>("Skill no encontrada", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> agregarSkilll(@RequestBody Skills skill) {
        iSkillsService.saveSkills(skill);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarSkills(@PathVariable int id, @RequestBody Skills skill) {
        if (iSkillsService.traerSkillsPorId(id) == null) {
            return new ResponseEntity<>("Skills no encontrada", HttpStatus.NOT_FOUND);
        }

        Skills nuevaSkill = iSkillsService.traerSkillsPorId(id);

        nuevaSkill.setNombreSkill(skill.getNombreSkill());
        nuevaSkill.setPorcentaje(skill.getPorcentaje());
        nuevaSkill.setImgsrc(skill.getImgsrc());
        nuevaSkill.setColorInterno(skill.getColorInterno());
        nuevaSkill.setColorExterno(skill.getColorExterno());

        iSkillsService.saveSkills(nuevaSkill);

        return new ResponseEntity<>(nuevaSkill, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarSkills(@PathVariable int id) {

        if (iSkillsService.traerSkillsPorId(id) == null) {
            return new ResponseEntity<>("Skill no encontrada", HttpStatus.BAD_REQUEST);
        }
        iSkillsService.deleteSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
