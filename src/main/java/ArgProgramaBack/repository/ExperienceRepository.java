package ArgProgramaBack.repository;

import ArgProgramaBack.model.Experience;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    List<Experience> findByTipo(String tipo);

}

