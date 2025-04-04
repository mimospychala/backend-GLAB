package ch.bbcag.backend;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.account.AccountRepository;
import ch.bbcag.backend.account.AccountService;
import ch.bbcag.backend.categorie.Categorie;
import ch.bbcag.backend.categorie.CategorieService;
import ch.bbcag.backend.price.Price;
import ch.bbcag.backend.price.PriceService;
import ch.bbcag.backend.product.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DatabaseSeed implements CommandLineRunner {
    private final AccountService accountService;
    private final CategorieService categorieService;
    private final PriceService priceService;
    private final ProductRepository productRepository;

    public DatabaseSeed(AccountService accountService, CategorieService categorieService, PriceService priceService, ProductRepository productRepository) {
        this.categorieService = categorieService;
        this.accountService = accountService;
        this.priceService = priceService;
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Account account = new Account();
        account.setEmail("admin@bbcag.com");
        account.setPassword("admin1234");
        account.setUsername("Admin");
        accountService.create(account);

        Categorie categorie = new Categorie();
        categorie.setName("Burger");
        categorieService.insert(categorie);

        Price price = new Price();
        price.setVolume("0.5l");
        price.setPrice(BigDecimal.valueOf(1.53));
        priceService.insert(price);
    }
}
