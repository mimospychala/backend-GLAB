package ch.bbcag.backend.account;

public class TokenResponseDTO {
    private AccountResponseDTO account;
    private String token;

    public AccountResponseDTO getAccount() {
        return account;
    }

    public void setAccount(AccountResponseDTO account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
