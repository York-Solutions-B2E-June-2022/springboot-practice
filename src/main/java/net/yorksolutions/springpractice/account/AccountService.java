package net.yorksolutions.springpractice.account;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountService {

    AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void register(String username, String password) {
       Optional<Account> existingAccount = accountRepository.getByUsername(username);
        if (!existingAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Account account = new Account(username, password);
        accountRepository.save(account);
    }
}
