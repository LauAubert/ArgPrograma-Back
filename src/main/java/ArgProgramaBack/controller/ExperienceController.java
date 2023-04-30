package ArgProgramaBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ArgProgramaBack.Usuario.LoginService;
import ArgProgramaBack.model.Experience;
import ArgProgramaBack.service.ExperienceService;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    public ExperienceService experienceService;
    

    // Endpoints para obtener todas las experiencias y una experiencia por id
    @GetMapping("/")
    public ResponseEntity<List<Experience>> getAllExperiences() {
        List<Experience> experiences = experienceService.getAllExperiences();
        return new ResponseEntity<>(experiences, HttpStatus.OK);
    }
    
    // Endpoint para crear una nueva experiencia
    @PostMapping("/")
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Experience newExperience = experienceService.createExperience(experience);
        return ResponseEntity.status(HttpStatus.CREATED).body(newExperience);
    }

    // Endpoint para actualizar una experiencia existente
    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience experience, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Experience updatedExperience = experienceService.updateExperience(id, experience);
        return ResponseEntity.status(HttpStatus.OK).body(updatedExperience);
    }

    // Endpoint para eliminar una experiencia existente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        experienceService.deleteExperience(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

