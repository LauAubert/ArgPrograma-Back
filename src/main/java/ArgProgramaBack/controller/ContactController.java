package ArgProgramaBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ArgProgramaBack.Usuario.LoginService;
import ArgProgramaBack.model.Contact;
import ArgProgramaBack.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/")
    public ResponseEntity<List<Contact>> updateContacts(@RequestBody List<Contact> contacts, @RequestHeader("Authorization") String token) {
        // validar JWT
        if (!LoginService.validarJwt(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<Contact> updatedContacts = contactService.updateContacts(contacts);
        if (!updatedContacts.isEmpty()) {
            return ResponseEntity.ok(updatedContacts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }
}
