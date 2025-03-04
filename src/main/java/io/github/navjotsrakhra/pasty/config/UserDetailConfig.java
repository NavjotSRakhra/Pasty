package io.github.navjotsrakhra.pasty.config;

import io.github.navjotsrakhra.pasty.repository.UserAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserDetailConfig {
    @Bean
    public UserDetailsService userDetailsService(UserAccountRepository userAccountRepository) {
        return username ->
                userAccountRepository
                        .findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
