package ArgProgramaBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import ArgProgramaBack.model.*;
import ArgProgramaBack.repository.*;
import java.util.*;

// import javax.json.Json;


@RestController
@RequestMapping("/all")
public class AllController {
    @Autowired
    AboutmeRepository AboutmeRepository;
    @Autowired
    ContactRepository ContactRepository;
    @Autowired
    EducationRepository EducationRepository;
    @Autowired
    SkillRepository SkillRepository;
    @Autowired
    ExperienceRepository ExperienceRepository;

    @GetMapping("/")
    public ResponseEntity<Object> getAll() throws JsonProcessingException{
        // Creo un JSON con todos los datos de la base de datos
        Map<String, Object> jsonResponse = new HashMap<>();
        long aboutmeID = 1;
        jsonResponse.put("aboutme", AboutmeRepository.findById(aboutmeID));
        jsonResponse.put("contact", ContactRepository.findAll());
        jsonResponse.put("education", EducationRepository.findAll());

        jsonResponse.put("skills", SkillRepository.findByTipo("skill"));
        jsonResponse.put("languages", SkillRepository.findByTipo("language"));

        jsonResponse.put("jobs", ExperienceRepository.findByTipo("job"));
        jsonResponse.put("projects", ExperienceRepository.findByTipo("project"));
     
        // devuelvo el JSON como ResponseEntity
        // ObjectMapper objectMapper = new ObjectMapper();
        // String json = objectMapper.writeValueAsString(jsonResponse);

        return ResponseEntity.ok(jsonResponse);
    }
}
