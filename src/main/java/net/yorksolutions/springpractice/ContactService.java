package net.yorksolutions.springpractice;

import org.springframework.stereotype.Service;

// A service is a place to store all the logic for a controller
// it is the file where the "work" is done
@Service
public class ContactService {

    public void create(String name, String phoneNumber) {
        // add the new contact to the database
    }

    public void list() {
        // return the list of contacts from the db
    }

    public void getSpecificContact(String name) {
        // return a single contact by its name
    }

    public void updatePhoneNumber(String name, String newNumber) {
        // update a contacts phone number in the database
    }

    public void delete(String name) {
        // delete a contact from the database
    }
}
