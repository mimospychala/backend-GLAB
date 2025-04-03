package ch.bbcag.backend.account;

import ch.bbcag.backend.configuration.JWTConfiguration;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final JWTConfiguration jwtConfiguration;
    private final PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository, JWTConfiguration jwtConfiguration, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.jwtConfiguration = jwtConfiguration;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return account;
    }

    public String generateToken(Account account) {
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(account.getId() + "")
                .claim("username", account.getUsername())
                .expirationTime(new Date(new Date().getTime() + jwtConfiguration.getExpiration()))
                .build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.parse(jwtConfiguration.getAlgorithm())), claimsSet);
        try {
            JWSSigner signer = new MACSigner(jwtConfiguration.getSecret());
            signedJWT.sign(signer);
            return signedJWT.serialize();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existsByEmailOrUsername(String email, String username) {
        return accountRepository.existsByUsernameOrEmail(email, username);
    }


    public Account create(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }
}
