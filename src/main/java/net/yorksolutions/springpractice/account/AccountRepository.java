package net.yorksolutions.springpractice.account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> getByUsername(String username);
    Optional<Account> getByUsernameAndPassword(String username, String password);
}
