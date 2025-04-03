package ch.bbcag.backend.account;

import jakarta.validation.constraints.NotBlank;

public class AccountRequestDTO extends AccountSignInDTO {
    @NotBlank(message = "Username can't be blank")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
