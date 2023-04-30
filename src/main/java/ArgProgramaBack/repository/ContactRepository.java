package ArgProgramaBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ArgProgramaBack.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
}
