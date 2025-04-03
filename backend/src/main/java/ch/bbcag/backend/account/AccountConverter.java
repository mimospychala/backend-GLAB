package ch.bbcag.backend.account;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.Jwt;

public class AccountConverter implements Converter<Jwt, AccountAuthenticationToken> {
    @Override
    public AccountAuthenticationToken convert(Jwt jwt) {
        int id = Integer.parseInt(jwt.getSubject());
        String username = jwt.getClaimAsString("username");
        Account account = new Account();
        account.setId(id);
        account.setUsername(username);
        return new AccountAuthenticationToken(jwt, account);
    }
}
