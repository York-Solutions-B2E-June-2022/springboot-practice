package net.yorksolutions.springpractice.contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Long> {
    ArrayList<ContactEntity> findByName(String name);

    // THIS WILL NOT WORK
    // ArrayList<ContactEntity> findByphone_number();
    // findByphone_number => [find, by, phone_number]

    ArrayList<ContactEntity> findByPhoneNumber(String phoneNumber);
    // findByFooNumber => [find, by, foo, number] -> SELECT * WHERE foo_number = X

    ArrayList<ContactEntity> findByNameAndPhoneNumber(String name, String phoneNumber);

}