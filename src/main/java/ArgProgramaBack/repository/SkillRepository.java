package ArgProgramaBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ArgProgramaBack.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByTipo(String tipo);
}

