package com.portfolio.backend.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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

import com.portfolio.backend.entity.Skills;
import com.portfolio.backend.service.ISkillsService;

@CrossOrigin(origins = "https://portfolioap-2022.web.app")
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

    @PostMapping("/crear")
    public ResponseEntity<?> agregarSkilll(@RequestBody Skills skill) {
        if (StringUtils.isBlank(skill.getNombreSkill())
                && StringUtils.isBlank(skill.getImgsrc())
                && skill.getPorcentaje() <= 0) {
            return new ResponseEntity<>("Campos obligatorios vacios o incorrectos.", HttpStatus.BAD_REQUEST);

        }
        iSkillsService.saveSkills(skill);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarSkills(@PathVariable int id, @RequestBody Skills skill) {
        if (iSkillsService.traerSkillsPorId(id) == null) {
            return new ResponseEntity<>("Skills no encontrada", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(skill.getNombreSkill())
                && StringUtils.isBlank(skill.getImgsrc())
                && skill.getPorcentaje() <= 0) {

            return new ResponseEntity<>("Campos obligatorios vacios o incorrectos.", HttpStatus.BAD_REQUEST);
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

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarSkills(@PathVariable int id) {

        if (iSkillsService.traerSkillsPorId(id) == null) {
            return new ResponseEntity<>("Skill no encontrada", HttpStatus.NOT_FOUND);
        }
        iSkillsService.deleteSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
