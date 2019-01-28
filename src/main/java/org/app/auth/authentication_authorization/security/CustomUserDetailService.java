package org.app.auth.authentication_authorization.security;

import org.app.auth.authentication_authorization.ApplicationUser;
import org.app.auth.customer.CustomerEntity;
import org.app.auth.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@EnableJpaRepositories(basePackages = {"org.app.auth"})
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CustomerEntity optionalUsers = customerRepository.findByUserName(username);

        ApplicationUser defaultUser = loadApplicationByUsername(username);

        if(optionalUsers == null)
            throw new UsernameNotFoundException("This user is not registered.");
        else
            return new User(defaultUser.getUsername(), defaultUser.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));

    }

    public ApplicationUser loadApplicationByUsername(String username) {

        CustomerEntity optionalUsers = customerRepository.findByUserName(username);

        return new ApplicationUser(optionalUsers.getUserName(), optionalUsers.getPassword());

    }
}
