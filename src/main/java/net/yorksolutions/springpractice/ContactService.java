package net.yorksolutions.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void updatePhoneNumber(String name, String newNumber) {
        // update a contacts phone number in the database
    }

    public void delete(String name) {
        // delete a contact from the database
    }

}
