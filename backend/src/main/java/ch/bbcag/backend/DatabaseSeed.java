package ch.bbcag.backend;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.account.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeed implements CommandLineRunner {
    private final AccountService accountService;

    public DatabaseSeed(AccountService accountService) {
        this.accountService = accountService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Account account = new Account();
        account.setEmail("admin@bbcag.com");
        account.setPassword("admin1234");
        account.setUsername("Admin");
        accountService.create(account);
    }
}
