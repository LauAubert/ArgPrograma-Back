package ArgProgramaBack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ArgProgramaBack.model.Aboutme;
import ArgProgramaBack.repository.AboutmeRepository;

@Service
public class AboutmeService {

    @Autowired
    private AboutmeRepository repository;

    public Optional<Aboutme> findById(Long id) {
        return repository.findById(id);
    }
    
    public Aboutme createAboutme(Aboutme aboutme) {
        return repository.save(aboutme);
    }

    public List<Aboutme> getAllAboutmes() {
        return repository.findAll();
    }

    public Aboutme updateAboutme(Long id, Aboutme aboutme) {
        Optional<Aboutme> aboutmeOptional = repository.findById(id);
        if (aboutmeOptional.isPresent()) {
            return repository.save(aboutme);
        }
        else {
            throw new RuntimeException("No se pudo encontrar la experiencia con el ID proporcionado");
        }
    }

    public void deleteAboutme(Long id) {
        repository.deleteById(id);
    }
}
