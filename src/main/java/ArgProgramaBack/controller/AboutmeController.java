package ArgProgramaBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ArgProgramaBack.Usuario.LoginService;
import ArgProgramaBack.model.Aboutme;
import ArgProgramaBack.service.AboutmeService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aboutme")
public class AboutmeController {

    @Autowired
    public AboutmeService aboutmeService;
    

    
    @GetMapping("/")
    public ResponseEntity<List<Aboutme>> getAllAboutmes() {
        List<Aboutme> aboutmes = aboutmeService.getAllAboutmes();
        return new ResponseEntity<>(aboutmes, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Aboutme> getAboutmeById(@PathVariable Long id) {
        Optional<Aboutme> aboutme = aboutmeService.findById(id);
        if (aboutme.isPresent()) {
            return new ResponseEntity<>(aboutme.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("/")
    public ResponseEntity<Aboutme> createAboutme(@RequestBody Aboutme aboutme, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Aboutme newAboutme = aboutmeService.createAboutme(aboutme);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAboutme);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Aboutme> updateAboutme(@PathVariable Long id, @RequestBody Aboutme aboutme, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Aboutme updatedAboutme = aboutmeService.updateAboutme(id, aboutme);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAboutme);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAboutme(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        // Verificar si el token es válido
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        aboutmeService.deleteAboutme(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}


