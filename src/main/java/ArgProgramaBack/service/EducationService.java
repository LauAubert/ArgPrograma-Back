package ArgProgramaBack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ArgProgramaBack.model.Education;
import ArgProgramaBack.repository.EducationRepository;

@Service
public class EducationService {
    
    @Autowired
    private EducationRepository repository;

    public Optional<Education> findById(Long id) {
        return repository.findById(id);
    }
    
    public Education createEducation(Education education) {
        return repository.save(education);
    }

    public List<Education> getAllEducations() {
        return repository.findAll();
    }

    public Education updateEducation(Long id, Education education) {
        Optional<Education> educationOptional = repository.findById(id);
        if (educationOptional.isPresent()) {
            return repository.save(education);
        }
        else {
            throw new RuntimeException("No se pudo encontrar la experiencia con el ID proporcionado");
        }
    }

    public void deleteEducation(Long id) {
        repository.deleteById(id);
    }
}
