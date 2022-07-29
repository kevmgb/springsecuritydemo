package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.entity.User;
import com.example.springsecuritydemo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository usersRepo;

    public JwtUserDetailsService(UserRepository usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public com.example.springsecuritydemo.entity.User loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<com.example.springsecuritydemo.entity.User> user = usersRepo.findByEmail(email);

        if (user.isPresent()) {
            User appUser = user.get();
            if(appUser.getEmail().equals(email)){
                appUser.setId(appUser.getId());
                usersRepo.save(appUser);
                return new User(appUser.getId(), appUser.getEmail(), appUser.getPassword());
            }
        }
        throw new UsernameNotFoundException("Email "+email+" not found.");
    }
}
