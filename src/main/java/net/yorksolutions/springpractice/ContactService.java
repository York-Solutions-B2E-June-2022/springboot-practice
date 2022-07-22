package net.yorksolutions.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

// A service is a place to store all the logic for a controller
// it is the file where the "work" is done
@Service
public class ContactService {

    ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public void create(String name, String phoneNumber) {
        // add the new contact to the database
        ContactEntity contact = new ContactEntity(name, phoneNumber);
        repository.save(contact);
    }

    public Iterable<ContactEntity> list() {
        // return the list of contacts from the db
        return repository.findAll();
    }

    public Optional<ContactEntity> getSpecificContact(Long id) {
        // return a single contact by its name
        return repository.findById(id);
    }

    public void updatePhoneNumber(Long id, String newNumber) {
        Optional<ContactEntity> contactOpt = repository.findById(id);
        if (contactOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        ContactEntity contact = contactOpt.get();
        contact.phoneNumber = newNumber;
        repository.save(contact);
    }

    public void delete(Long id) {
        Optional<ContactEntity> contactOpt = repository.findById(id);
        if (contactOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        repository.delete(contactOpt.get());
    }

    public ArrayList<ContactEntity> getByName(String name) {
        return repository.findByName(name);
    }

    public ArrayList<ContactEntity> getByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }

}
