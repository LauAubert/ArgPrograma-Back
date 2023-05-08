package ArgProgramaBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ArgProgramaBack.Usuario.LoginService;
import ArgProgramaBack.model.Skill;
import ArgProgramaBack.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    public SkillService skillService;
    
    @GetMapping("/")
    public ResponseEntity<List<Skill>> getAllSkills() {
        List<Skill> skills = skillService.getAllSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    
    @GetMapping("/{tipo}")
    public List<Skill> getSkillsByTipo(@PathVariable String tipo) {
        return skillService.getSkillsByType(tipo);
    }
    
    
    @PostMapping("/")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Skill newSkill = skillService.createSkill(skill);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSkill);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skill, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Skill updatedSkill = skillService.updateSkill(id, skill);
        return ResponseEntity.status(HttpStatus.OK).body(updatedSkill);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        skillService.deleteSkill(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
