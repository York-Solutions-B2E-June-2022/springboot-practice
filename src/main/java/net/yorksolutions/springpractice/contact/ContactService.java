package net.yorksolutions.springpractice.contact;

import net.yorksolutions.springpractice.account.Account;
import net.yorksolutions.springpractice.account.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

// A service is a place to store all the logic for a controller
// it is the file where the "work" is done
@Service
public class ContactService {

    ContactRepository contactRepository;
    AccountRepository accountRepository;

    public ContactService(ContactRepository contactRepository, AccountRepository accountRepository) {
        this.contactRepository = contactRepository;
        this.accountRepository = accountRepository;
    }

    public void create(String name, String phoneNumber) {
        // add the new contact to the database
        ContactEntity contact = new ContactEntity(name, phoneNumber);
        contactRepository.save(contact);
    }

    public Iterable<ContactEntity> list(String username, String password) {
        // to check if their username + password is correct
//        Optional<Account> account = accountRepository.getByUsername(username);
//        if (account.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
//        }
//        if (account.get().password != password) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
//        }

        Optional<Account> account = accountRepository.getByUsernameAndPassword(username, password);
        if (account.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        // return the list of contacts from the db
        return contactRepository.findAll();
    }

    public Optional<ContactEntity> getSpecificContact(Long id) {
        // return a single contact by its name
        return contactRepository.findById(id);
    }

    public void updatePhoneNumber(Long id, String newNumber) {
        Optional<ContactEntity> contactOpt = contactRepository.findById(id);
        if (contactOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        ContactEntity contact = contactOpt.get();
        contact.phoneNumber = newNumber;
        contactRepository.save(contact);
    }

    public void delete(Long id) {
        Optional<ContactEntity> contactOpt = contactRepository.findById(id);
        if (contactOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        contactRepository.delete(contactOpt.get());
    }

    public ArrayList<ContactEntity> getByName(String name) {
        return contactRepository.findByName(name);
    }

    public ArrayList<ContactEntity> getByPhoneNumber(String phoneNumber) {
        return contactRepository.findByPhoneNumber(phoneNumber);
    }

    public ArrayList<ContactEntity> getByNameAndPhoneNumber(String name, String phoneNumber) {
        return contactRepository.findByNameAndPhoneNumber(name, phoneNumber);
    }
}
