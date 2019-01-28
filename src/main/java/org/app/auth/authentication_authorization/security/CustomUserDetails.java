package org.app.auth.authentication_authorization.security;

import lombok.NoArgsConstructor;
import org.app.auth.authority.Authority;
import org.app.auth.customer.CustomerEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
public class CustomUserDetails extends CustomerEntity implements UserDetails {

    public CustomUserDetails(final CustomerEntity entity) {
        super(entity);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*return getAuthorities()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());*/

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (Authority r :super.getAuthority()) {

            authorities.add(new SimpleGrantedAuthority(r.getAuthority()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
