package net.yorksolutions.springpractice.contact;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// an entity used to define what a table in the database looks like
// the class you are going to use as an entity must be marked with the @Entity annotation
// this is so springboot knows that it is an entity
@Entity
public class ContactEntity {

    // every entity must have a ID field
    // this is a value that is unique to every row in the table
    // the id property must be marked with the @Id annotation so that spring boot knows the field to use as the id
    // the id will be marked as the primary key for the table
    @Id
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    // property's on the
    // entity object will be columns in the table that is generated
    @JsonProperty
    String name;

    @JsonProperty
    String phoneNumber; // -> phone_number
//    String phonenumber; // -> phonenumber
//    String phone_number; // -> phone_number

    // if you have a constructor for you class spring boot needs you also define a
    // "no args" constructor, so it can do what it needs to do in the background.
    public ContactEntity() {
    }

    public ContactEntity(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
