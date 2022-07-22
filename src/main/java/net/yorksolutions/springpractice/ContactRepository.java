package net.yorksolutions.springpractice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Long> {
    ArrayList<ContactEntity> findByName(String name);

    ArrayList<ContactEntity> findByPhoneNumber(String phoneNumber);
}
