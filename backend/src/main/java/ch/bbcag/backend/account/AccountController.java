package ch.bbcag.backend.account;

import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(AccountController.PATH)
public class AccountController {
    public static final String PATH = "/accounts";

    private final AccountService accountService;
    private final AuthenticationManager authenticationManager;

    public AccountController(AccountService accountService, AuthenticationManager authenticationManager) {
        this.accountService = accountService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup")
    @SecurityRequirements
    public ResponseEntity<?> signUp(@Valid @RequestBody AccountRequestDTO accountRequestDTO) {
        if (accountService.existsByEmailOrUsername(accountRequestDTO.getEmail(), accountRequestDTO.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        Account account = AccountMapper.fromDTO(accountRequestDTO);
        account = accountService.create(account);
        AccountResponseDTO accountResponseDTO = AccountMapper.toDTO(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponseDTO);
    }

    @PostMapping("/signin")
    @SecurityRequirements
    public ResponseEntity<?> signIn(@Valid @RequestBody AccountSignInDTO accountSignInDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(accountSignInDTO.getEmail(), accountSignInDTO.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Account account = (Account) authentication.getPrincipal();
        String token = accountService.generateToken(account);
        TokenResponseDTO dto = AccountMapper.toDTO(account, token);
        return ResponseEntity.ok(dto);
    }
}


