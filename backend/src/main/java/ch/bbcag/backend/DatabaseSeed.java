package ch.bbcag.backend;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.account.AccountRepository;
import ch.bbcag.backend.bid.Bid;
import ch.bbcag.backend.bid.BidRepository;
import ch.bbcag.backend.bid.BidStatus;
import ch.bbcag.backend.container.Container;
import ch.bbcag.backend.container.ContainerRepository;
import ch.bbcag.backend.container.ContainerStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DatabaseSeed {

    @Bean
    CommandLineRunner seedDatabase(
            AccountRepository accountRepository,
            ContainerRepository containerRepository,
            BidRepository bidRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {

            // ⚠️ Nur seeden, wenn DB leer ist
            if (accountRepository.count() > 0) {
                return;
            }

            /* =========================
               ACCOUNTS
               ========================= */

            Account alice = new Account();
            alice.setEmail("alice@test.ch");
            alice.setUsername("alice");
            alice.setPassword(passwordEncoder.encode("password123"));
            alice.setBalance(new BigDecimal("500"));

            Account bob = new Account();
            bob.setEmail("bob@test.ch");
            bob.setUsername("bob");
            bob.setPassword(passwordEncoder.encode("password123"));
            bob.setBalance(new BigDecimal("300"));

            Account charlie = new Account();
            charlie.setEmail("charlie@test.ch");
            charlie.setUsername("charlie");
            charlie.setPassword(passwordEncoder.encode("password123"));
            charlie.setBalance(new BigDecimal("800"));

            accountRepository.saveAll(List.of(alice, bob, charlie));

            /* =========================
               CONTAINERS
               ========================= */

            Container container1 = new Container();
            container1.setOwner(alice);
            container1.setName("Mystery Tech Box");
            container1.setDescription("High-end tech gadgets, maybe you get lucky.");
            container1.setAskingPrice(new BigDecimal("50"));
            container1.setImageUrls(List.of(
                    "https://picsum.photos/seed/tech1/600",
                    "https://picsum.photos/seed/tech2/600"
            ));
            container1.setCreatedAt(LocalDateTime.now());
            container1.setStatus(ContainerStatus.ACTIVE);

            Container container2 = new Container();
            container2.setOwner(bob);
            container2.setName("Luxury Watch Case");
            container2.setDescription("Luxury watches – rare and valuable.");
            container2.setAskingPrice(new BigDecimal("100"));
            container2.setImageUrls(List.of(
                    "https://picsum.photos/seed/watch1/600",
                    "https://picsum.photos/seed/watch2/600"
            ));
            container2.setCreatedAt(LocalDateTime.now());
            container2.setStatus(ContainerStatus.ACTIVE);

            Container container3 = new Container();
            container3.setOwner(charlie);
            container3.setName("Gaming Loot Crate");
            container3.setDescription("Gaming gear, skins and collectibles.");
            container3.setAskingPrice(new BigDecimal("30"));
            container3.setImageUrls(List.of(
                    "https://picsum.photos/seed/game1/600",
                    "https://picsum.photos/seed/game2/600"
            ));
            container3.setCreatedAt(LocalDateTime.now());
            container3.setStatus(ContainerStatus.ACTIVE);

            containerRepository.saveAll(List.of(container1, container2, container3));

            /* =========================
               BIDS
               ========================= */

            // Bob bietet auf Alice's Container
            Bid bid1 = new Bid();
            bid1.setAccount(bob);
            bid1.setContainer(container1);
            bid1.setAmount(new BigDecimal("60"));
            bid1.setCreatedAt(LocalDateTime.now());
            bid1.setStatus(BidStatus.PENDING);
            bob.setBalance(bob.getBalance().subtract(bid1.getAmount()));

            // Charlie überbietet Bob
            Bid bid2 = new Bid();
            bid2.setAccount(charlie);
            bid2.setContainer(container1);
            bid2.setAmount(new BigDecimal("80"));
            bid2.setCreatedAt(LocalDateTime.now());
            bid2.setStatus(BidStatus.PENDING);
            charlie.setBalance(charlie.getBalance().subtract(bid2.getAmount()));

            // Alice bietet auf Bobs Container
            Bid bid3 = new Bid();
            bid3.setAccount(alice);
            bid3.setContainer(container2);
            bid3.setAmount(new BigDecimal("120"));
            bid3.setCreatedAt(LocalDateTime.now());
            bid3.setStatus(BidStatus.PENDING);
            alice.setBalance(alice.getBalance().subtract(bid3.getAmount()));

            accountRepository.saveAll(List.of(alice, bob, charlie));
            bidRepository.saveAll(List.of(bid1, bid2, bid3));

            System.out.println("✅ Database seeded successfully");
        };
    }
}
