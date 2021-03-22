package com.oa.authserver.service;

import com.oa.authserver.domain.SecurityUser;
import com.oa.authserver.domain.User;
import com.oa.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    public UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByUsername(s);
        if (user == null)
            throw new UsernameNotFoundException("Invalid username or password.");

        return new SecurityUser(user);
    }
}
