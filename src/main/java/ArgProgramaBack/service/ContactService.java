package ArgProgramaBack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ArgProgramaBack.model.Contact;
import ArgProgramaBack.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public Optional<Contact> findById(Long id) {
        return repository.findById(id);
    }
    
    public Contact createContact(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public Contact updateContact(Long id, Contact contact) {
        Optional<Contact> contactOptional = repository.findById(id);
        if (contactOptional.isPresent()) {
            return repository.save(contact);
        }
        else {
            throw new RuntimeException("No se pudo encontrar el dato de contacto con el ID proporcionado");
        }
    }

    public void deleteContact(Long id) {
        repository.deleteById(id);
    }

    public List<Contact> updateContacts(List<Contact> contacts) {
        List<Contact> updatedContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            Optional<Contact> contactOptional = repository.findById(contact.getId());
            if (contactOptional.isPresent()) {
                Contact updatedContact = repository.save(contact);
                updatedContacts.add(updatedContact);
            }
            else {
                throw new RuntimeException("No se pudo encontrar el dato de contacto con el ID proporcionado");
            }
        }
        return updatedContacts;
    }
    
}