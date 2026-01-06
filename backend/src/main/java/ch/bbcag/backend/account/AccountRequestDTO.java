package ch.bbcag.backend.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class AccountRequestDTO extends AccountSignInDTO {

    @NotBlank(message = "Username can't be blank")
    private String username;

    @NotNull(message = "Balance can't be null")
    @PositiveOrZero(message = "Balance must be >= 0")
    private BigDecimal balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
