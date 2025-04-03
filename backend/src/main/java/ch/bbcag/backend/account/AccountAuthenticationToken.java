package ch.bbcag.backend.account;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;


public class AccountAuthenticationToken extends AbstractAuthenticationToken {
    private final Account account;
    private final Jwt jwt;

    public AccountAuthenticationToken(Jwt jwt, Account account) {
        this(jwt, account, List.of());
    }

    public AccountAuthenticationToken(Jwt jwt, Account account, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.account = account;
        this.jwt = jwt;
    }

    @Override
    public Object getCredentials() {
        return jwt;
    }

    @Override
    public Object getPrincipal() {
        return account;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }
}