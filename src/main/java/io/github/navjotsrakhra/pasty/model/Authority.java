package io.github.navjotsrakhra.pasty.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Authority {
    ADMIN,
    USER;

    public SimpleGrantedAuthority getSimpleGrantedAuthority() {
        return new SimpleGrantedAuthority(name());
    }
}