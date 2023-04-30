package ArgProgramaBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ArgProgramaBack.Usuario.LoginService;
import ArgProgramaBack.model.Education;
import ArgProgramaBack.service.EducationService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/education")
public class EducationController {

    @Autowired
    public EducationService educationService;
    

    
    @GetMapping("/")
    public ResponseEntity<List<Education>> getAllEducations() {
        List<Education> educations = educationService.getAllEducations();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long id) {
        Optional<Education> education = educationService.findById(id);
        if (education.isPresent()) {
            return new ResponseEntity<>(education.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("/")
    public ResponseEntity<Education> createEducation(@RequestBody Education education, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Education newEducation = educationService.createEducation(education);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEducation);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable Long id, @RequestBody Education education, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Education updatedEducation = educationService.updateEducation(id, education);
        return ResponseEntity.status(HttpStatus.OK).body(updatedEducation);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        educationService.deleteEducation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}


