package net.yorksolutions.springpractice.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    public String username;

    public String password;

    public Account() {};
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
