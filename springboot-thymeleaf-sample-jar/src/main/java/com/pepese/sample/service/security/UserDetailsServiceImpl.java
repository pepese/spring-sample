package com.pepese.sample.service.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pepese.sample.model.User;

public class UserDetailsServiceImpl implements UserDetailsService {
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = new User();
            user.setName(username);
            return new UserDetails(user);
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("user not found", e);
        }
    }
}