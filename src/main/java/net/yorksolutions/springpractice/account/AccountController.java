package net.yorksolutions.springpractice.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    AccountService accountService;
    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/register")
    public void register(@RequestParam String username, @RequestParam String password) {
        // do the work (call a function on the account service)
      accountService.register(username, password);
    }
}
