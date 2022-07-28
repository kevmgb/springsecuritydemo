//package com.example.springsecuritydemo.service.impl;
//
//import com.example.springsecuritydemo.entity.User;
//import com.example.springsecuritydemo.repository.UserRepository;
//import com.example.springsecuritydemo.service.UserDetailsImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
//
////    @Value("${maxLoginAttempts}")
////    private int MAX_LOGIN_ATTEMPTS;
//
//    static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        int userAttempts;
//        LocalDateTime lastAttempted;
//        Boolean enabled;
//        String error = "";
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
//
////        userAttempts = user.getLoginAttempts();
////        lastAttempted = user.getLastLoginDate();
////        enabled = user.getEnabled();
////
////        if (userAttempts + 1 >= MAX_LOGIN_ATTEMPTS) {
////            error = "User account is locked! <br>Username : "
////                    + username + "<br>Last Attempted on : " + lastAttempted;
////            throw new LockedException(error);
////        }
////
////        if (!enabled) {
////            error = "User account is not enabled! <br>Username : "
////                    + username;
////            throw new LockedException(error);
////        }
//
//        return UserDetailsImpl.build(user);
//    }
//
//}
