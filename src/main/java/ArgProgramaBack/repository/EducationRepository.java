package ArgProgramaBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ArgProgramaBack.model.Education;

public interface EducationRepository extends JpaRepository<Education, Long>{
    
}
