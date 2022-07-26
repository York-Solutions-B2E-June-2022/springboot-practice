package net.yorksolutions.springpractice.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;


// a controller class in spring boot maps the request "endpoint" to the function you want to be run on your service
// the rest controller annotation marks the class as a "controller" class
@RestController

// request mapping modify the "url" you will use to talk to the controller (the class)
@RequestMapping("/contacts")
public class ContactController {

    public ContactService service; // this var stores the reference to your service object

    // this is our class constructor (springboot is passing the contact service object to this class for us!)
    @Autowired
    public ContactController(ContactService contactService) {
        this.service = contactService;
    }

    // Create (C) part of crud
    @GetMapping("/add") // <-- a get mapping "maps" an endpoint to a specific function
    public void addContact(@RequestParam String name, @RequestParam String phoneNumber) {
        service.create(name, phoneNumber);
    }

    // Read (R) part of crud
    @GetMapping("/list") // <-- the endpoint for this mapping is http://localhost:8080/contacts/list
    public Iterable<ContactEntity> listContacts(@RequestParam String username, @RequestParam String password) {
        return service.list(username, password);
    }

    @GetMapping("/get")
    public Optional<ContactEntity> getSpecificContact(@RequestParam Long id) { // a request param allows you to send data in a request url
        return service.getSpecificContact(id);
    }

    // Update (U) part of crud
    @GetMapping("/updatePhoneNumber") // the name for the request param must match the name for the url variable!
    public void updatePhoneNumber(@RequestParam Long id, @RequestParam String newNumber) {
        service.updatePhoneNumber(id, newNumber);
    }

    // Delete (D) part of crud
    @GetMapping("/delete") // <-- the endpoint for this request would be http://localhost:8080/delete?name=adam
    public void deleteContact(@RequestParam Long id) {
        service.delete(id);
    }

    @GetMapping("/getByName")
    public ArrayList<ContactEntity> getByName(@RequestParam String name) {
        return service.getByName(name);
    }

    @GetMapping("/getByPhoneNumber")
    public ArrayList<ContactEntity> getByPhoneNumber(@RequestParam String phoneNumber) {
        return service.getByPhoneNumber(phoneNumber);
    }

    @GetMapping("/getNameAndPhoneNumber")
    public ArrayList<ContactEntity> getByPhoneNumber(@RequestParam String name, @RequestParam String phoneNumber) {
        return service.getByNameAndPhoneNumber(name, phoneNumber);
    }
}
