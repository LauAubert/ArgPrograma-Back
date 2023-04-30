package ArgProgramaBack.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import ArgProgramaBack.model.Skill;
import ArgProgramaBack.repository.SkillRepository;

@Service
public class SkillService {

    @Autowired
    private SkillRepository repository;

    public Optional<Skill> findById(Long id) {
        return repository.findById(id);
    }
    
    public Skill createSkill(Skill skill) {
        return repository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return repository.findAll();
    }

    public Skill updateSkill(Long id, Skill skill) {
        Optional<Skill> skillOptional = repository.findById(id);
        if (skillOptional.isPresent()) {
            return repository.save(skill);
        }
        else {
            throw new RuntimeException("No se pudo encontrar la habilidad con el ID proporcionado");
        }
    }

    public void deleteSkill(Long id) {
        repository.deleteById(id);
    }
    
    public List<Skill> getSkillsByType(String type) {
        return repository.findByTipo(type);
    }
}

