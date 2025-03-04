package io.github.navjotsrakhra.pasty.controller;

import io.github.navjotsrakhra.pasty.exception.UsernameExistsException;
import io.github.navjotsrakhra.pasty.model.UserAccount;
import io.github.navjotsrakhra.pasty.model.request.PasswordChangeRequestDto;
import io.github.navjotsrakhra.pasty.model.request.UserAccountRequestDto;
import io.github.navjotsrakhra.pasty.service.UserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping
    public ResponseEntity<?> createUserAccount(@RequestBody UserAccountRequestDto userAccount) throws UsernameExistsException {
        this.userAccountService.createUserAccount(userAccount);
        return
                ResponseEntity
                        .status(HttpStatus.SEE_OTHER)
                        .header("Location", "/")
                        .build();
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody PasswordChangeRequestDto passwordChangeRequestDto, Principal principal) throws UsernameExistsException {
        this.userAccountService.changeUserPassword(Optional.ofNullable(principal), passwordChangeRequestDto.getOldPassword(), passwordChangeRequestDto.getNewPassword());
        return ResponseEntity
                .noContent()
                .build();
    }
}
