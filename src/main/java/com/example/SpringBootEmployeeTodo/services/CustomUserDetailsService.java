package com.example.SpringBootEmployeeTodo.services;

import com.example.SpringBootEmployeeTodo.models.RegisterDetails;
import com.example.SpringBootEmployeeTodo.models.Roles;
import com.example.SpringBootEmployeeTodo.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RegisterDetails user = registerDetailsRepository.findByUserName(username).orElse(null);

        if (user == null) {
            throw new RuntimeException("User Not Found");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        Set<Roles> userRoles = user.getRoles();

        for (Roles role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new User(user.getUserName(), user.getPassword(), authorities);
    }
}
