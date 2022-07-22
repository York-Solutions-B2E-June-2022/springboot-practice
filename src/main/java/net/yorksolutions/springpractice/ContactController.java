package net.yorksolutions.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Iterable<ContactEntity> listContacts() {
        return service.list();
    }

    @GetMapping("/get")
    public Optional<ContactEntity> getSpecificContact(@RequestParam Long id) { // a request param allows you to send data in a request url
        return service.getSpecificContact(id);
    }

    // Update (U) part of crud
    @GetMapping("/updatePhoneNumber") // the name for the request param must match the name for the url variable!
    public void updatePhoneNumber(@RequestParam String name, @RequestParam String newNumber) {
        service.updatePhoneNumber(name, newNumber);
    }

    // Delete (D) part of crud
    @GetMapping("/delete") // <-- the endpoint for this request would be http://localhost:8080/delete?name=adam
    public void deleteContact(@RequestParam String name) {
        service.delete(name);
    }
}
