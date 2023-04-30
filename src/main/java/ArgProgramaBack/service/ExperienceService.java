package ArgProgramaBack.service;

import ArgProgramaBack.model.Experience;
import ArgProgramaBack.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository repository;

    
    public Optional<Experience> findById(Long id) {
        return repository.findById(id);
    }
    
    public Experience createExperience(Experience experience) {
        return repository.save(experience);
    }

    public List<Experience> getAllExperiences() {
        return repository.findAll();
    }

    public Experience updateExperience(Long id, Experience experience) {
        Optional<Experience> experienceOptional = repository.findById(id);
        if (experienceOptional.isPresent()) {
            return repository.save(experience);
        }
        else {
            throw new RuntimeException("No se pudo encontrar la experiencia con el ID proporcionado");
        }
    }

    public void deleteExperience(Long id) {
        repository.deleteById(id);
    }

}