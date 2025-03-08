package io.github.navjotsrakhra.pasty.service;

import io.github.navjotsrakhra.pasty.exception.UsernameExistsException;
import io.github.navjotsrakhra.pasty.model.UserAccount;
import io.github.navjotsrakhra.pasty.model.mapper.UserAccountMapper;
import io.github.navjotsrakhra.pasty.model.request.UserAccountRequestDto;
import io.github.navjotsrakhra.pasty.repository.UserAccountRepository;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;
    private final UserAccountMapper userAccountMapper;
    private final PasswordEncoder passwordEncoder;

    public UserAccountService(UserAccountRepository userAccountRepository, UserAccountMapper userAccountMapper, PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.userAccountMapper = userAccountMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUserAccount(UserAccountRequestDto userAccountRequestDto) throws UsernameExistsException {

        if (this.userAccountRepository.existsByUsername(userAccountRequestDto.getUsername())) {
            throw new UsernameExistsException(userAccountRequestDto.getUsername());
        }

        UserAccount userAccount = userAccountMapper.toUserAccount(userAccountRequestDto);
        userAccount.setPassword(passwordEncoder.encode(userAccountRequestDto.getPassword()));

        userAccountRepository.save(userAccount);
    }

    public void changeUserPassword(Optional<Principal> principal, String oldPassword, String newPassword) {
        if (principal.isPresent()) {
            Optional<UserAccount> userAccount = userAccountRepository.findByUsername(principal.get().getName());
            if (userAccount.get().getPassword().equals(passwordEncoder.encode(oldPassword))) {
                userAccount.get().setPassword(passwordEncoder.encode(newPassword));
                userAccountRepository.save(userAccount.get());
            } else {
                throw new Error(); // Old password doesn't match
            }
        }
        throw new Error(); // User not logged in
    }
}
