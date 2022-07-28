package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.entity.User;
import com.example.springsecuritydemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class JwtUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

    @Autowired
    UserRepository usersRepo;

    @Override
    public com.example.springsecuritydemo.entity.User loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<com.example.springsecuritydemo.entity.User> user = usersRepo.findByEmail(email);
        System.out.println(user);
        com.example.springsecuritydemo.entity.User appUser = user.get();

        if(null != appUser && appUser.getEmail().equals(email)){

            Set<SimpleGrantedAuthority> authorities = new HashSet<>(1);
            appUser.setId(appUser.getId());
            usersRepo.save(appUser);
            return new User(appUser.getId(), appUser.getEmail(), appUser.getPassword());
        } else {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Email "+email+" not found.");
        }
    }
}
